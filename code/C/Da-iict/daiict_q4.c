#include<stdio.h>

#define LCHILD(x) 2 * x + 1
#define RCHILD(x) 2 * x + 2
#define PARENT(x) (x-1)/ 2

typedef struct node {
    long long int data ;
} node ;

typedef struct minHeap {
    int size ;
    node *elem ;
} minHeap ;

typedef struct maxHeap {
    int size ;
    node *elem ;
} maxHeap ;

minHeap initMinHeap() {
    minHeap hp ;
    hp.size = 0 ;
    return hp ;
}

maxHeap initMaxHeap() {
    maxHeap hp ;
    hp.size = 0 ;
    return hp ;
}

void min_insertNode(minHeap *hp, long long int data) {
    // allocating space
    if(hp->size) {
        hp->elem = realloc(hp->elem, (hp->size + 1) * sizeof(node)) ;
    } else {
        hp->elem = malloc(sizeof(node)) ;
    }

    // initializing the node with value
    node nd ;
    nd.data = data ;

    // Positioning the node at the right position in the min heap
    int i = (hp->size)++ ;
    while(i && nd.data < hp->elem[PARENT(i)].data) {
        hp->elem[i] = hp->elem[PARENT(i)] ;
        i = PARENT(i) ;
    }
    hp->elem[i] = nd ;
}

void max_insertNode(maxHeap *hp, long long int data) {
    // allocating space
    if(hp->size) {
        hp->elem = realloc(hp->elem, (hp->size + 1) * sizeof(node)) ;
    } else {
        hp->elem = malloc(sizeof(node)) ;
    }

    // initializing the node with value
    node nd ;
    nd.data = data ;

    // Positioning the node at the right position in the max heap
    int i = (hp->size)++ ;
    while(i && nd.data > hp->elem[PARENT(i)].data) {
        hp->elem[i] = hp->elem[PARENT(i)] ;
        i = PARENT(i) ;
    }
    hp->elem[i] = nd ;
}

void swap(node *n1, node *n2) {
    node temp = *n1 ;
    *n1 = *n2 ;
    *n2 = temp ;
}

void min_heapify(minHeap *hp, int i) {
    int smallest = (LCHILD(i) < hp->size && hp->elem[LCHILD(i)].data < hp->elem[i].data) ? LCHILD(i) : i ;
    if(RCHILD(i) < hp->size && hp->elem[RCHILD(i)].data < hp->elem[smallest].data) {			//modified largest with smallest
        smallest = RCHILD(i) ;
    }
    if(smallest != i) {
        swap(&(hp->elem[i]), &(hp->elem[smallest])) ;
        min_heapify(hp, smallest) ;
    }
}

void max_heapify(maxHeap *hp, int i) {
    int largest = (LCHILD(i) < hp->size && hp->elem[LCHILD(i)].data > hp->elem[i].data) ? LCHILD(i) : i ;
    if(RCHILD(i) < hp->size && hp->elem[RCHILD(i)].data > hp->elem[largest].data) {
        largest = RCHILD(i) ;
    }
    if(largest != i) {
        swap(&(hp->elem[i]), &(hp->elem[largest])) ;
        max_heapify(hp, largest) ;
    }
}

void min_deleteNode(minHeap *hp) {
    if(hp->size) {
       // printf("Deleting node %d\n\n", hp->elem[0].data) ;
        hp->elem[0] = hp->elem[--(hp->size)] ;
        hp->elem = realloc(hp->elem, hp->size * sizeof(node)) ;
        min_heapify(hp, 0) ;
    } else {
        //printf("\nMin Heap is empty!\n") ;
        free(hp->elem) ;
    }
}

void max_deleteNode(maxHeap *hp) {
    if(hp->size) {
       // printf("Deleting node %d\n\n", hp->elem[0].data) ;
        hp->elem[0] = hp->elem[--(hp->size)] ;
        hp->elem = realloc(hp->elem, hp->size * sizeof(node)) ;
        max_heapify(hp, 0) ;
    } else {
        //printf("\nMin Heap is empty!\n") ;
        free(hp->elem) ;
    }
}


void buildMinHeap(minHeap *hp, int *arr, int size) {
    int i ;

    // Insertion into the heap without violating the shape property
    for(i = 0; i < size; i++) {
        if(hp->size) {
            hp->elem = realloc(hp->elem, (hp->size + 1) * sizeof(node)) ;
        } else {
            hp->elem = malloc(sizeof(node)) ;
        }
        node nd ;
        nd.data = arr[i] ;
        hp->elem[(hp->size)++] = nd ;
    }

    // Making sure that heap property is also satisfied
    for(i = (hp->size - 1) / 2; i >= 0; i--) {
        min_heapify(hp, i) ;
    }
}

void buildMaxHeap(maxHeap *hp, int *arr, int size) {
    int i ;

    // Insertion into the heap without violating the shape property
    for(i = 0; i < size; i++) {
        if(hp->size) {
            hp->elem = realloc(hp->elem, (hp->size + 1) * sizeof(node)) ;
        } else {
            hp->elem = malloc(sizeof(node)) ;
        }
        node nd ;
        nd.data = arr[i] ;
        hp->elem[(hp->size)++] = nd ;
    }

    // Making sure that heap property is also satisfied
    for(i = (hp->size - 1) / 2; i >= 0; i--) {
        max_heapify(hp, i) ;
    }
}


int main()
{
	int N,temp,size_array=0,size_output=0,count=0;
	long long int data;
	scanf("%d",&N);
	//printf("fine\n");
	minHeap min_hp = initMinHeap();			//output heap
	maxHeap max_hp = initMaxHeap();			//input heap
	while(N--)
	{
		scanf("%d",&temp);
		if(temp==1)
		{
			scanf("%lld",&data);
			//else
			//{
				max_insertNode(&max_hp,data);
				
				//size_array++;
			//}	
			//printf("in\n");		
			count++;
			if(count!=0 && count%3==0)
			{
				min_insertNode(&min_hp,(&max_hp)->elem[0].data);
				max_deleteNode(&max_hp);
				//max_insertNode(&max_hp,data);
				//temp.data=data;
				//temp1=((&max_hp)->elem[0]);
				//swap(&temp1, &temp);
				//max_heapify(&max_hp, 0);
				size_output++;
			}
			else if(size_output>0 && ((&max_hp)->elem[0].data) > ((&min_hp)->elem[0].data))
			{
				//int t_temp= (&max_hp)->elem[0].data;
				//(&max_hp)->elem[0].data = (&min_hp)->elem[0].data;
				//(&min_hp)->elem[0].data = t_temp;
				swap(&((&max_hp)->elem[0]), &((&min_hp)->elem[0]));
				max_heapify(&max_hp, 0);
				min_heapify(&min_hp, 0);
			}
		}
		else
		{
			if(count>=3 || size_output>0)
				printf("%lld\n",((&min_hp)->elem[0].data));
			else
				printf("Not enough walks\n");
		}
	}
	return 0;
}

