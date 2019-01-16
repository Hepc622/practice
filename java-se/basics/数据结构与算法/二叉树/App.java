package 二叉树;


/**
 * 此类是：二叉树	
 * 		二叉树的度：2
 * 		二叉树某层的总节点：二叉树层m,至多有2^m-1二叉树的总节点数
 * 		二叉树i的双亲节点：
 * 			若i为偶数则它的双亲节点为i/2
 * 			若i为奇数则它的双亲节点为i-1/2
 * 		二叉树的某一个节点的子节点的序号：
 * 			若二叉树的最大节点数为偶数则所有的分支节点既有左孩子，又有右孩子。
 * 			若二叉树的最大节点数为奇数则所有的分支节点只有左孩子，没有右孩子。
 * 			节点为i
 * 			左孩子：i2+1
 * 			右孩子：i2+2
 * @author hpc
 * @param <E>
 * @date 2017年1月4日 下午6:45:49
 */
public class App<E>{
	private Tree root;
	private int size;
	public static void main(String[] args) {
		App<Integer> app = new App<Integer>();
		app.insert(1,app.root);
		app.insert(2,app.root);
		app.insert(10,app.root);
		app.insert(3,app.root);
		app.insert(13,app.root);
		app.insert(4,app.root);
		app.insert(10,app.root);
		app.insert(6,app.root);
		app.insert(7,app.root);
		app.insert(15,app.root);
		app.insert(8,app.root);
		app.insert(7,app.root);
		app.insert(15,app.root);
		app.insert(8,app.root);
		app.insert(0,app.root);
		app.insert(-10,app.root);
		app.insert(-4,app.root);
		
		System.out.println(app.size);
		System.out.println(app.height(app.root));
		System.out.println(app.inOrder(app.root));
		System.out.println(app.preOrder(app.root));
		System.out.println(app.postOrder(app.root));
		System.out.println(app.findMax(app.root));
		System.out.println(app.findMin(app.root));
		System.out.println(app.findNode(app.root,3).right.right.data);
		System.out.println(app.contains(app.root, 0));
		app.clear();
	}
	/**
	 * 插入数据到树中
	 */
	public void insert(E data,Tree tree){
		if(root == null){
			root = new Tree(data);
			size++;
		}
		if(tree!=null)
			if(data.hashCode()<tree.data.hashCode()){
				// 如果节点等于空就将输入插入
				if(tree.left==null){
					tree.left=new Tree(data);
					size++;
				}
				// 如果节点不等于空就取出其节点继续遍历
				else
					insert(data,tree.left);
			}else if(data.hashCode()>tree.data.hashCode()){
				if(tree.right==null){
					tree.right=new Tree(data);
					size++;
				}
				else
					insert(data,tree.right);
			}
	}
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size==0;
	}
	/**
	 * 返回节点数
	 * @return
	 */
	public int size(){
		return size;
	}
	/**
     * 返回二叉树的高度或者深度,即结点的最大层次
     * @return
     */
    public int height(Tree tree){
    	int r,l;
    	if(tree==null)
    		return 0;
    	else{
	    	l=height(tree.left)+1;
	    	r=height(tree.right)+1;
	    	return l<=r?r:l;
	    }
    }

    /**
     * 先根次序遍历
     */
    public String preOrder(Tree tree){
    	if(tree==null){
    		return "";
    	}else{
    		return tree.data+" "+preOrder(tree.left)+preOrder(tree.right);
    	}
    }

    /**
     * 中根次序遍历
     */
    public String inOrder(Tree tree){
    	if(tree==null){
    		return "";
    	}else{
    		return inOrder(tree.left)+tree.data+" "+inOrder(tree.right);
    	}
    }
    /**
     * 后根次序遍历
     */
    public String postOrder(Tree tree){
    	if(tree==null){
    		return "";
    	}else{
    		return postOrder(tree.left)+postOrder(tree.right)+tree.data+" ";
    	}
    }

    /**
     * 层次遍历
     */
    public String levelOrder(){
    	return "";
    }

    /**
     * 删除
     */
    public void remove(E data){
    }

    /**
     * 查找最小值
     * @return
     */
	public E findMin(Tree tree){
		if(tree.left==null){
			return tree.data;
		}else{
			return findMin(tree.left);
		}
		
    }

    /**
     * 查找最大值
     * @return
     */
    public E findMax(Tree tree){
    	if(tree.right==null){
			return tree.data;
		}else{
			return findMax(tree.right);
		}
    }

    /**
     * 根据值找到结点
     * @param data
     * @return
     */
    public Tree findNode(Tree tree,E data){
    	if(tree==null){
    		return null;
    	}
    	if(tree.data.equals(data)){
    		return tree;
    	}else{
    		Tree left = findNode(tree.left,data);
    		Tree right = findNode(tree.right,data);
    		return left==null?right:left;
    	}
    }

    /**
     * 是否包含某个值
     * @param data
     * @return
     */
    public boolean contains(Tree tree,E data){
    	boolean l=false;
    	boolean r=false;
    	if(tree==null) return false;
    	else
	    	if(tree.data.equals(data)){
	    		return true;
	    	}else{
	    		l=contains(tree.left,data);
	    		r=contains(tree.right,data);
	    		return l?l:r;
	    	}
    }

    /**
     * 清空
     */
    public void clear(){
    	this.root=null;
    }
    
	class Tree{
		E data;
		Tree left;
		Tree right;
		public Tree(E data) {
			this(data,null,null);
		}
		public Tree(E data,Tree left,Tree right) {
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}
}

