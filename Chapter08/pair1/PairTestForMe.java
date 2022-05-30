package pair1;
/**
* @date 2022-05-30
* @author Robin Wan
*/
public class PairTestForMe{
	public static void main(String[] args){
		String[] words = {"I","am","is","god"};
		Pair<String> result = ArrayAlg.compareMinMax(words);
		System.out.println("The minimum is " + result.getMinimum());
		System.out.println("The minimum is " + result.getMaximum());
	}
}

class ArrayAlg{
	public static Pair<String> compareMinMax(String[] target){
		if(target.length == 0 || target == null) return null;
		String minimum = target[0];
		String maximum = target[0];
		for(int i = 1;i < target.length;i++){
			if(minimum.compareTo(target[i])>0) minimum = target[i];
			if(maximum.compareTo(target[i])<0) maximum = target[i];
		}
		return new Pair<>(minimum,maximum);
		
	}
}
class Pair<T>{
	private T minimum;
	private T maximum;
	
	public Pair(){minimum = null;maximum = null;}
	public Pair(T minimum,T maximum){
		this.minimum = minimum;
		this.maximum = maximum;
	}
	
	public T getMinimum(){
		return minimum;
	}
	public T getMaximum(){
		return maximum;
	}
	
	public void setMinimum(T minimum){
		this.minimum = minimum;
	}
	public void setMaximum(T maximum){
		this.maximum = maximum;
	}
}