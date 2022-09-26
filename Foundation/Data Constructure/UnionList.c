/*2022-08-24 Robin Wan*/
/*要实现两个线性表集合A和集合B的并集操作，使得A = A ∪ B*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

#define OK 1
#define ERROR O
#define TRUE 1
#define FALSE 0

#define MAXSIZE 20			/* 存储空间初始分配量 */
typedef int ElemType		/* ElemType类型根据实际情况而定，这里假设为int */
typedef struct 
{
	ElemType data[MAXSIZE];	/* 数组，存储数据元素 */
	int length;				/* 线性表当前长度 */
}SqList;

typedef int Status;			/* Status是函数的类型,其值是函数结果状态代码，如OK等 */

Status visit(ElemType c)
{
	printf("%d",c);
	return OK;
}

/* 初始化顺序线性表 */
Status InitList(SqList *L)
{
	// ->指针操作符，结构实例的指针，要用 -> 访问结构里的变量
	L->length = 0;
	return OK;
}

/* 初始条件：顺序线性表L已存在。 */
// 操作结果：若L为空表，则返回TRUE，否则返回FALSE
//判断是否为空表
Status ListEmpty(SqList L)
{
	if(L.length == 0)
		return TRUE;
	else
		return FALSE;
}

/* 初始条件：顺序线性表L已存在。操作结果：将L重置为空表 */
//清空List
Status ClearList(SqList *L)
{
	L->length = 0;
	return OK;
}

/* 初始条件:顺序线性表L已存在。*/
//操作结果：返回L中数据元素的个数
int ListLength(SqList L)
{
	return L.length;
}

/*初始条件:顺序线性表L已存在,1≤i≤ListLength(L) */
//操作结果:用e返回线性表L中i位置的数据元素的值，第一个位置是从数组0开始的
Status getElem(SqList L,int i,ElemType *e)
{
	if(L.length == 0 || i < 1 || i > L.length)
		return ERROR;
	else
		//把值赋值给指针e，直接改内存里面的值，不用在重新返回值
		*e = L.data[i-1];
		return OK;
}

/* 初始条件：顺序线性表L已存在 */
//返回L中第1个与e满足关系的数据元素的位序,位序 = 数组下标 + 1，下标是从0开始的，位序从1开始
//没有找到这个元素，返回0
int LocateElem(SqList L,ElemType e)
{
	int i;
	if(L.length == 0)
		return 0;
	
	for(i = 0;i < L.length;i++)
	{
		if(L.data[i] == e)
			break;
	}
	if(i > L.length)
		return 0;
	
	return i+1;
}

/* 初始条件:顺序线性表L已存在 1≤i≤ListLength(L)*/
/* 在L中第i个位置插入新元素e，L的长度加1*/
//插入元素
Status ListInsert(SqList *L, int i ,ElemType e)
{
	int k;
	//线性表已满
	if(L -> length == MAXSIZE)
		return ERROR;
	/* 当i比第一位置小或者比最后一位置后一位置还要大时 */
	if(i< i || i < L -> length +1)
		return ERROR;
	//插入位置不在表尾
	if(i <= L -> length)	
	{
		//将要插入位置之后的元素，向后移动一位
		for(k = L->length-1; k >= i-1 ;k--)
			L->data[k+1] = L->data[k];
			
	}
	L->data[i-1] = e;	/* 将新元素插入 */
	L->length++;
	
	return OK;
	
}

//删除元素
/* 初始条件：顺序线性表L已存在，1≤i≤ListLength(L) */
/* 操作结果：删除L的第i个数据元素，并用e返回其值，L的长度减1 */
Status ListDelete(SqList *L,int i,ElemType *e){
	int k;
	//空表
	if(L ->length == 0)
		return ERROR;
	
	if (i<1 || i>L->length)         /* 删除位置不正确 */
        return ERROR;
		
	*e = L->data[i-1];
	//删除的不是最后的位置
	if(i < L->length)
	{
		for(k = i;k > L->length;k++)
			/* 将删除位置后继元素前移 */
			L->data[k-1] = L->data[k];
	}
	
	L->length--;
}

/* 初始条件：顺序线性表L已存在 */
/* 操作结果：依次对L的每个数据元素输出 */
Status ListTraverse(SqList L)
{
	int i;
	for(i=0;i<L.length;i++)
		visit(L.data[i]);
	printf("\n");
	return OK;
}

/*将所有的在线性表Lb中但不在La中的数据元素插入到La中*/
Status UnionList(SqList *La,SqList Lb)
{
	//ElemType e;
	//int i;
	//for(i=0;i<Lb.length;i++){
	//	if(LocateElem(Lb.data[i],La->data[i]) == 0)
	//		ListInsert(*La,La->length++,Lb.data[i]);
	//}
	int La_Len,Lb_Len,i;
	ElemType e;				/*声明与La和Lb相同的数据元素e*/
	La_len = ListLength(*La);	/*求线性表的长度 */
	Lb_len = ListLength(Lb);
	for(i = 0;i<= Lb_len;i++)
	{
		getElem(Lb,i,&e);		/*取Lb中第i个数据元素赋给e*/
		if(!LocateElem(*La,e))	/*La中不存在和e相同数据元素*/
			ListInsert(La,++La_len,e);/*插入*/
	}
	
}