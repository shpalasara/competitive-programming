package January_16;
/*
1
15654 4
1 2
1000 11
11 100
111 1110
*/
import java.io.*;
import java.util.*;

public class SEAKAM_1 {
static int mi = 1000000007;
public static void main(String[] args)throws IOException{
PrintWriter pw = new PrintWriter(System.out);
InputReader in = new InputReader(System.in);

long[] fact = new long[100001];
fact[1] = 1;

for(int i=2;i<=100000;i++){
fact[i] = i*fact[i-1];
fact[i]%=mi;
}

int t = in.nextInt();

for(int i=0;i<t;i++){
int n = in.nextInt();
int m = in.nextInt();
int c = 0;



int w = (int) Math.pow(2, m);
int[] x = new int[m];
int[] y = new int[m];
int[] z = new int[100001];
int o=1;
for(int j=0;j<m;j++){
x[j] = in.nextInt();
y[j] = in.nextInt();
if(z[x[j]]==0){
z[x[j]]=o;
o++;
}

if(z[y[j]]==0){
z[y[j]] = o;
o++;
}
}

if(n>100){
c=0;
}

else{
DisjointUnionSets dus = new DisjointUnionSets(n);

int[][] a = new int[n][n];


for(int j=0;j<m;j++){
a[x[j]-1][y[j]-1] = 1;
a[y[j]-1][x[j]-1] = 1;
}

for(int j=0;j<n;j++){
for(int k=0;k<n;k++){
if(a[j][k]==0){
dus.union(j, k);
}
}
}


int yu = dus.find(0);


for(int j=0;j<n;j++){
if(dus.find(j)!=yu){
//System.out.println("ff");
c=1;
break;
}
}
}

if(c==1){
//System.out.println("ho");
pw.println("0");
}

else{
long ans=0;
for(int j=1;j<w;j++){
int[] mark = new int[n];
int count=0;
int one=0;
int two=0;
//int three=0;
long sum=0;

int hel = 0;
Graph g1 = new Graph(15);

for(int k=1;k<=m;k++){
if((j&(1<<(k-1)))>0){
count++;
//System.out.println(x[k-1]+" "+y[k-1]+" "+j);
mark[x[k-1]-1]++;
mark[y[k-1]-1]++;
g1.addEdge(z[x[k-1]], z[y[k-1]]);

if(mark[x[k-1]-1]==1){
one++;
}

if(mark[y[k-1]-1]==1){
one++;
}

if(mark[x[k-1]-1]==2){
two++;
one--;
}

if(mark[y[k-1]-1]==2){
one--;
two++;
}

if(mark[x[k-1]-1]==3){
hel=1;
break;
}

if(mark[y[k-1]-1]==3){
hel=1;
break;
}
}
}

//System.out.println(g1.isCyclic());
if(hel == 0 && g1.isCyclic()==false){
//System.out.println(one+" "+two);
sum = (fact[n-(one+two*2)/2]);
//System.out.println(one+" "+two+" "+sum+" "+j);
//
sum*=Math.pow(2,one/2);

//System.out.println(sum);

if(count%2==0){
ans-=sum;
}

else{
ans+=sum;
}
}

}

while(ans<0){
ans+=mi;
}

ans%=mi;
ans=fact[n]-ans;
if(ans<0){
ans+=mi;
}

ans%=mi;
pw.println(ans);
}


}

pw.close();
}

static class InputReader {

private InputStream stream;
private byte[] buf = new byte[8192];
private int curChar;
private int snumChars;
private SpaceCharFilter filter;

public InputReader(InputStream stream) {
this.stream = stream;
}

public int snext() {
if (snumChars == -1)
throw new InputMismatchException();
if (curChar >= snumChars) {
curChar = 0;
try {
snumChars = stream.read(buf);
} catch (IOException e) {
throw new InputMismatchException();
}
if (snumChars <= 0)
return -1;
}
return buf[curChar++];
}

public int nextInt() {
int c = snext();
while (isSpaceChar(c))
c = snext();
int sgn = 1;
if (c == '-') {
sgn = -1;
c = snext();
}

int res = 0;

do {
if (c < '0' || c > '9')
throw new InputMismatchException();
res *= 10;
res += c - '0';
c = snext();
} while (!isSpaceChar(c));

return res * sgn;
}

public long nextLong() {
int c = snext();
while (isSpaceChar(c))
c = snext();
int sgn = 1;
if (c == '-') {
sgn = -1;
c = snext();
}

long res = 0;

do {
if (c < '0' || c > '9')
throw new InputMismatchException();
res *= 10;
res += c - '0';
c = snext();
} while (!isSpaceChar(c));

return res * sgn;
}

public String readString() {
int c = snext();
while (isSpaceChar(c))
c = snext();
StringBuilder res = new StringBuilder();
do {
res.appendCodePoint(c);
c = snext();
} while (!isSpaceChar(c));
return res.toString();
}

public boolean isSpaceChar(int c) {
if (filter != null)
return filter.isSpaceChar(c);
return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
}

public interface SpaceCharFilter {
public boolean isSpaceChar(int ch);
}
}
}

class DisjointUnionSets {

int[] rank, parent;
int n;

public DisjointUnionSets(int n) {
rank = new int[n];
parent = new int[n];
this.n=n;
makeSet();
}

void makeSet() {

for(int i=0;i<n;i++){ // Initially, all elements are in their own set.
parent[i] = i;
}
}

int find(int x){ // Finds the representative of the set that x is an element of
if(parent[x]!=x){
//if x is not the parent of itself
// Then x is not the representative of his set,

return find(parent[x]);
// so we recursively call Find on its parent
// and move i's node directly under the representative of this set
}
else{
return x;
}

//return parent[x];
}

void union(int x, int y){ // Unites the set that includes x and the set that includes y
int xRoot = find(x); // Find the representatives (or the root nodes) for the set that includes x
int yRoot = find(y); // And do the same for the set that includes y
if(xRoot == yRoot) // Elements are in the same set, no need to unite anything.
return;
if(rank[xRoot]<rank[yRoot]){ // If x's rank is less than y's rank
parent[xRoot] = yRoot; // Then move x under y so that depth of tree remains less
}

else if(rank[yRoot]<rank[xRoot]){ // Else if y's rank is less than x's rank
parent[yRoot] = xRoot; // Then move y under x so that depth of tree remains less
}

else{ // Else if their ranks are the same
parent[yRoot] = xRoot; // Then move y under x (doesn't matter which one goes where)
rank[xRoot] = rank[xRoot] + 1; // And increment the the result tree's rank by 1
}
}

}

class Graph
{
private int V; // No. of vertices
private LinkedList<Integer> adj[]; // Adjacency List Represntation

// Constructor
Graph(int v) {
V = v;
adj = new LinkedList[v];
for(int i=0; i<v; ++i)
adj[i] = new LinkedList();
}

// Function to add an edge into the graph
void addEdge(int v,int w) {
adj[v].add(w);
adj[w].add(v);
}

// A recursive function that uses visited[] and parent to detect
// cycle in subgraph reachable from vertex v.
Boolean isCyclicUtil(int v, Boolean visited[], int parent)
{
// Mark the current node as visited
visited[v] = true;
Integer i;

// Recur for all the vertices adjacent to this vertex
Iterator<Integer> it = adj[v].iterator();
while (it.hasNext())
{
i = it.next();

// If an adjacent is not visited, then recur for that
// adjacent
if (!visited[i])
{
if (isCyclicUtil(i, visited, v))
return true;
}

// If an adjacent is visited and not parent of current
// vertex, then there is a cycle.
else if (i != parent)
return true;
}
return false;
}

// Returns true if the graph contains a cycle, else false.
Boolean isCyclic()
{
// Mark all the vertices as not visited and not part of
// recursion stack
Boolean visited[] = new Boolean[V];
for (int i = 0; i < V; i++)
visited[i] = false;

// Call the recursive helper function to detect cycle in
// different DFS trees
for (int u = 0; u < V; u++)
if (!visited[u]) // Don't recur for u if already visited
if (isCyclicUtil(u, visited, -1))
return true;

return false;
}
}