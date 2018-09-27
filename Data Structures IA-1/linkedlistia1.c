#include<stdio.h>
#include<conio.h>
#include<malloc.h>

typedef struct node
{
int data;
struct node *link;
}NODE;

NODE *end;
NODE *start;
int count=0;
int max=0;

int insert(int x,int position)
{
NODE *ptr,*p;
int i;
ptr=(NODE*)malloc(sizeof(NODE));
ptr->data=x;
ptr->link=NULL;
if(x>max)
max=x;
if(ptr==NULL)
return 0;
else
if(count==0)
start=end=ptr;
else
if(position>count)
{
end->link=ptr;
end=ptr;
end->link=NULL;
}
else
if(position<=1)
{
ptr->link=start;
start=ptr;
}
else
{
p=start;
for(i=1;i<=position-2;i++)
p=p->link;
ptr->link=p->link;
p->link=ptr;
}
count++;
return 1;
}

void duplicate()
{
NODE *p;
int temp,i,rpt;
for(i=0;i<=max;i++)
{
p=start;
rpt=0;
while(p!=NULL)
{
if(i==p->data)
{
rpt++;
temp=i;
}
p=p->link;
}
if(rpt!=0&&rpt!=1)
printf("%d is repeated %d times\n",temp,rpt);
}
}

void sort()
{
NODE *s,*q,*p;
int i,j;
int temp;
s=start;
for(j=1;j<=max;j++)
{
while(s!=NULL)
{
p=s;
q=s->link;
while(q!=NULL)
{
if(q->data==s->data)
{
if(q==end)
    {
    p->link=NULL;
    end=p;
    }
else
    p->link=q->link;
}
p=p->link;
q=q->link;
}
s=s->link;
}
}
for(j=1;j<=count;j++)

{
for(i=1;i<=count;i++)
{
p=start;
q=start->link;
while(q!=NULL)
{
if(p->data>q->data)
{
temp=p->data;
p->data=q->data;
q->data=temp;
}
q=q->link;
p=p->link;
}

}
}
}


void traverse()
{
int i;
NODE *p;
p=start;
while(p!=NULL)
{
printf("%d\n",p->data);
p=p->link;
}
}

void main()
{

int option,x,position;
do{
printf("Enter your choice\n");
printf("1.Insert\n2.Duplicate\n3.Sort\n4.Traverse\n5.Quit\n");
scanf("%d",&option);
switch(option)
{
case 1:printf("Enter the element to be inserted along with position\n");
scanf("%d%d",&x,&position);
if(insert(x,position))
printf("Operation successful\n");
else
printf("Memory full\n");
break;
case 2:
    duplicate();
    break;
case 3:
    sort();
    break;
case 4:
    traverse();
    break;
        }
    }while(option!=5);
}
