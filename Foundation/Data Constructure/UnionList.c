/*2022-08-24 Robin Wan*/
/*Ҫʵ���������Ա���A�ͼ���B�Ĳ���������ʹ��A = A �� B*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

#define OK 1
#define ERROR O
#define TRUE 1
#define FALSE 0

#define MAXSIZE 20			/* �洢�ռ��ʼ������ */
typedef int ElemType		/* ElemType���͸���ʵ������������������Ϊint */
typedef struct 
{
	ElemType data[MAXSIZE];	/* ���飬�洢����Ԫ�� */
	int length;				/* ���Ա�ǰ���� */
}SqList;

typedef int Status;			/* Status�Ǻ���������,��ֵ�Ǻ������״̬���룬��OK�� */

Status visit(ElemType c)
{
	printf("%d",c);
	return OK;
}

/* ��ʼ��˳�����Ա� */
Status InitList(SqList *L)
{
	// ->ָ����������ṹʵ����ָ�룬Ҫ�� -> ���ʽṹ��ı���
	L->length = 0;
	return OK;
}

/* ��ʼ������˳�����Ա�L�Ѵ��ڡ� */
// �����������LΪ�ձ��򷵻�TRUE�����򷵻�FALSE
//�ж��Ƿ�Ϊ�ձ�
Status ListEmpty(SqList L)
{
	if(L.length == 0)
		return TRUE;
	else
		return FALSE;
}

/* ��ʼ������˳�����Ա�L�Ѵ��ڡ������������L����Ϊ�ձ� */
//���List
Status ClearList(SqList *L)
{
	L->length = 0;
	return OK;
}

/* ��ʼ����:˳�����Ա�L�Ѵ��ڡ�*/
//�������������L������Ԫ�صĸ���
int ListLength(SqList L)
{
	return L.length;
}

/*��ʼ����:˳�����Ա�L�Ѵ���,1��i��ListLength(L) */
//�������:��e�������Ա�L��iλ�õ�����Ԫ�ص�ֵ����һ��λ���Ǵ�����0��ʼ��
Status getElem(SqList L,int i,ElemType *e)
{
	if(L.length == 0 || i < 1 || i > L.length)
		return ERROR;
	else
		//��ֵ��ֵ��ָ��e��ֱ�Ӹ��ڴ������ֵ�����������·���ֵ
		*e = L.data[i-1];
		return OK;
}

/* ��ʼ������˳�����Ա�L�Ѵ��� */
//����L�е�1����e�����ϵ������Ԫ�ص�λ��,λ�� = �����±� + 1���±��Ǵ�0��ʼ�ģ�λ���1��ʼ
//û���ҵ����Ԫ�أ�����0
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

/* ��ʼ����:˳�����Ա�L�Ѵ��� 1��i��ListLength(L)*/
/* ��L�е�i��λ�ò�����Ԫ��e��L�ĳ��ȼ�1*/
//����Ԫ��
Status ListInsert(SqList *L, int i ,ElemType e)
{
	int k;
	//���Ա�����
	if(L -> length == MAXSIZE)
		return ERROR;
	/* ��i�ȵ�һλ��С���߱����һλ�ú�һλ�û�Ҫ��ʱ */
	if(i< i || i < L -> length +1)
		return ERROR;
	//����λ�ò��ڱ�β
	if(i <= L -> length)	
	{
		//��Ҫ����λ��֮���Ԫ�أ�����ƶ�һλ
		for(k = L->length-1; k >= i-1 ;k--)
			L->data[k+1] = L->data[k];
			
	}
	L->data[i-1] = e;	/* ����Ԫ�ز��� */
	L->length++;
	
	return OK;
	
}

//ɾ��Ԫ��
/* ��ʼ������˳�����Ա�L�Ѵ��ڣ�1��i��ListLength(L) */
/* ���������ɾ��L�ĵ�i������Ԫ�أ�����e������ֵ��L�ĳ��ȼ�1 */
Status ListDelete(SqList *L,int i,ElemType *e){
	int k;
	//�ձ�
	if(L ->length == 0)
		return ERROR;
	
	if (i<1 || i>L->length)         /* ɾ��λ�ò���ȷ */
        return ERROR;
		
	*e = L->data[i-1];
	//ɾ���Ĳ�������λ��
	if(i < L->length)
	{
		for(k = i;k > L->length;k++)
			/* ��ɾ��λ�ú��Ԫ��ǰ�� */
			L->data[k-1] = L->data[k];
	}
	
	L->length--;
}

/* ��ʼ������˳�����Ա�L�Ѵ��� */
/* ������������ζ�L��ÿ������Ԫ����� */
Status ListTraverse(SqList L)
{
	int i;
	for(i=0;i<L.length;i++)
		visit(L.data[i]);
	printf("\n");
	return OK;
}

/*�����е������Ա�Lb�е�����La�е�����Ԫ�ز��뵽La��*/
Status UnionList(SqList *La,SqList Lb)
{
	//ElemType e;
	//int i;
	//for(i=0;i<Lb.length;i++){
	//	if(LocateElem(Lb.data[i],La->data[i]) == 0)
	//		ListInsert(*La,La->length++,Lb.data[i]);
	//}
	int La_Len,Lb_Len,i;
	ElemType e;				/*������La��Lb��ͬ������Ԫ��e*/
	La_len = ListLength(*La);	/*�����Ա�ĳ��� */
	Lb_len = ListLength(Lb);
	for(i = 0;i<= Lb_len;i++)
	{
		getElem(Lb,i,&e);		/*ȡLb�е�i������Ԫ�ظ���e*/
		if(!LocateElem(*La,e))	/*La�в����ں�e��ͬ����Ԫ��*/
			ListInsert(La,++La_len,e);/*����*/
	}
	
}