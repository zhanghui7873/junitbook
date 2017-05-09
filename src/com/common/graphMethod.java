package com.common;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class graphMethod {
private List<Vetex> list;  //Vetex list
private int[][] dis;     //连接矩阵
private Queue<Vetex> univisited; //未访问顶点


	public graphMethod(List<Vetex> list, int[][] dis, Queue<Vetex> univisited) {
	this.list = list;
	this.dis = dis;
	this.univisited = univisited;
}
	
	public List<Vetex> getList() {
		return list;
	}
	public void setList(List<Vetex> list) {
		this.list = list;
	}
	public int[][] getDis() {
		return dis;
	}
	public void setDis(int[][] dis) {
		this.dis = dis;
	}
	public Queue<Vetex> getUnivisited() {
		return univisited;
	}
	public void setUnivisited(Queue<Vetex> univisited) {
		this.univisited = univisited;
	}
	public graphMethod()
	{
		
	}
	// the shortest distance from point A to point B,C and D
	// step 1; initial the data
	public graphMethod initialVetex()
	{
		ArrayList<Vetex> vetexlist=new ArrayList<Vetex>();
		Vetex VetexA=new Vetex("A",0);
		Vetex VetexB=new Vetex("B");
		Vetex VetexC=new Vetex("C");
		Vetex VetexD=new Vetex("D");
		Vetex VetexE=new Vetex("E");
		Vetex VetexF=new Vetex("F");
		vetexlist.add(VetexA);
		vetexlist.add(VetexB);
		vetexlist.add(VetexC);
		vetexlist.add(VetexD);
		vetexlist.add(VetexE);
		vetexlist.add(VetexF);
		list=new ArrayList<Vetex>();
		list.addAll(vetexlist);
		dis=initialVetexEdges();
		initialUnvisited();
		printGraph();
		graphMethod gm=new graphMethod(list,dis,univisited);
		return gm;
	}
	
	public void initialUnvisited()  //initialize the unvisited list 
	{
		univisited=new PriorityQueue<Vetex>();
		for(Vetex v:list)
		{
			univisited.add(v);
		}
		
	}
	public int[][] initialVetexEdges() //initialize the edges
	{
		int[][] distance={
			     {Integer.MAX_VALUE,6,3,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
				{6,Integer.MAX_VALUE,2,5,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {3,2,Integer.MAX_VALUE,3,4,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,5,3,Integer.MAX_VALUE,5,3},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,4,5,Integer.MAX_VALUE,5},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,3,5,Integer.MAX_VALUE}	
		};
		return distance;
	}
	//step 2: search
	 public void search()    //search the vetex and edges
	 {
		 while(!this.univisited.isEmpty())    //if the unvisited is not empty
		 {
			 Vetex v=this.univisited.element();  //obtain  the first element in queue
			 v.setMarked(true);                   //remark as visited
			 List<Vetex> li=getNeighbors(v);      //get neighbors
			 updateDistance(v,li);              //update the pathlen from the source point
			 System.out.println(this.univisited.poll().getName());       //pop the element
		 }
		 System.out.println("over");
	 }
	 public void  printGraph()
	 {
		 for(int i=0;i<list.size();i++)
		 {
			 for(int j=0;j<list.size();j++)
			 {
				 if(Integer.MAX_VALUE==dis[i][j])
				 {
					 System.out.print("X ");
					 continue;
				 }
				 System.out.print(dis[i][j]+"  ");
			 }
			 System.out.println();
		 }
	 }
	private void updateDistance(Vetex v, List<Vetex> li) { //updates the pathlen for different vetex
		
		for(Vetex vl:li)
		{
			int dd=v.getPathlen()+getDistance(v,vl);
			if(dd<vl.getPathlen()){
				vl.setPathlen(dd);
			}
		}
		
	}
   public int getDistance(Vetex vs,Vetex st) //according to the Vetex, find the distance with link matrix
   {
	   int sIndex=this.list.indexOf(vs);
	   int tIndex=this.list.indexOf(st);
	   return dis[sIndex][tIndex];
   }
	public List<Vetex> getNeighbors(Vetex v)  //get the neighbors for vetex 
	 {
		 List<Vetex> neighborsList=new ArrayList<Vetex>();
		 int index=this.list.indexOf(v);
		 for(int i=0;i<this.list.size();i++)
		 {
			 if(index==i)
			 {
				 continue;
			 }
			 int distt=this.dis[index][i];
			 if(Integer.MAX_VALUE>distt)
			 {
				 Vetex vj=this.list.get(i);
				 if(!vj.isMarked())
				 neighborsList.add(vj);
			 }
		 }
			 return neighborsList;
	 }
}

