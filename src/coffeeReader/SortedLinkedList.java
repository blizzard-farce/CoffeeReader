package coffeeReader;

public class SortedLinkedList<T> 
{
	LLNode<T> head; //stores the start of the list
	LLNode<T> currNode; //iterator for list
	LLNode<T> prevNode; //node before currNode for removing nodes
	
	/**
	 * default constructor
	 * creates empty SortedLinkedList and defaults markers to null
	 */
	public SortedLinkedList()
	{
		head = null;
		currNode = null;
	}
	
	/**
	 * constructor with first node inserted
	 * @param info
	 */
	public SortedLinkedList(T info)
	{
		add(info);
	}
	
	/**
	 * creates new node and adds to front of queue
	 * @param info
	 */
	public void add(T info)
	{
		LLNode<T> newNode = new LLNode<T>(info);
		newNode.setLink(head);
		head = newNode;
	}
	
	/**
	 * removes first node from SortedLinkedList containing specified info
	 * be careful - will remove first node it finds - need to use a unique info
	 * @param info
	 * @return
	 */
	public T remove(T info)
	{
		if (isEmpty())
		{
			return null;
		}
		else if (find(info))
		{
			findPrevious(currNode);
			
			prevNode.setLink(currNode.getLink());
			return currNode.getInfo();
		}
		return null;
	}
	
	/**
	 * returns true if the list is empty
	 * used primarily for error checking
	 * @return
	 */
	public boolean isEmpty()
	{
		if (head == null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * returns true if given info is found in list
	 * returns false if info doesn't exist in list
	 * @param info
	 * @return
	 */
	public boolean find(T info)
	{
		resetCurrNode();
		
		while (currNode.getLink() != null)
		{
			if (currNode.getInfo() == info)
			{
				return true;
			}
			else
			{
				currNode = currNode.getLink();
			}
		}
		
		return false;
		
	}
	
	/**
	 * iterates through list until given node is the next node
	 * @param node
	 */
	public LLNode<T> findPrevious(LLNode<T> node)
	{
		LLNode<T> prevNode = head;
		
		while (prevNode.getLink() != null)
		{
			if (prevNode.getLink() == node)
			{
				return prevNode;
			}
			else
			{
				prevNode = prevNode.getLink();
			}
		}
		return null;
	}
	
	/**
	 * resets currNode iterator to beginning of list
	 */
	public void resetCurrNode()
	{
		currNode = head;
	}
	
	/**
	 * sorts list by comparing first element to second, then third...
	 * first element after sorting will be the largest
	 * 
	 * @param index is the index of the array in each node that will be sorted on
	 * @param sortFlag true for descending, false for ascending
	 */
	public void sort(int index, boolean sortFlag)
	{
		resetCurrNode();
		
		LLNode<T> otherNode;
		String[] currNodeArray;
		String[] otherNodeArray;
		
		if (sortFlag)
		{
			while (currNode.getLink() != null)
			{
				currNodeArray = (String[]) currNode.getInfo();
				otherNode = currNode.getLink();
				while (otherNode.getLink() != null)
				{
					otherNodeArray = (String[]) otherNode.getInfo();
					if (currNodeArray[index].compareTo(otherNodeArray[index]) < 0)
					{
						trade(currNode, otherNode);
					}
					otherNode = otherNode.getLink();
				}
				currNode = currNode.getLink();
			}
		}
		if (!sortFlag)
		{
			while (currNode.getLink() != null)
			{
				currNodeArray = (String[]) currNode.getInfo();
				otherNode = currNode.getLink();
				while (otherNode.getLink() != null)
				{
					otherNodeArray = (String[]) otherNode.getInfo();
					if (currNodeArray[index].compareTo(otherNodeArray[index]) > 0)
					{
						trade(currNode, otherNode);
					}
					otherNode = otherNode.getLink();
				}
				currNode = currNode.getLink();
			}
		}
	}
	
	/**
	 * exchanges position of the two specified nodes
	 * @param nodeC
	 * @param nodeO
	 */
	public void trade(LLNode<T> nodeC, LLNode<T> nodeO)
	{
		LLNode<T> prevC;
		LLNode<T> prevO;
		
		if (nodeC == head)
		{
			prevC = null;
		}
		else
		{
			prevC = findPrevious(nodeC);
		}
		
		if (nodeC.getLink() == nodeO)
		{
			prevO = nodeC;
		}
		else
		{
			prevO = findPrevious(nodeO);
		}
		
		prevC.setLink(nodeO);
		prevO.setLink(nodeC);
	}
	
	/**
	 * simple print method that prints the contents of each link 
	 * in the list on their own line
	 * primarily for testing output
	 */
	public void print()
	{
		resetCurrNode();
		while (currNode.getLink() != null)
		{
			T currNodeInfo = currNode.getInfo();
			System.out.println(currNodeInfo);
			
			currNode = currNode.getLink();
		}
	}
}