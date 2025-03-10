import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class Sorts{
    public static Window screen = null;
    private static int count = 0;
    private static final int countfactor = 100;
    private static final int timeouttime = 10000;
	private static final boolean DEBUG = false;
	private static SplittableRandom rand = new SplittableRandom();
	private static void swap(List<Double> data, int one, int two) {
        double tmp = data.get(one);
        data.set(one, data.get(two));
        data.set(two, tmp);
    }
	
	public static int partition(List<Double> arr, int lo, int hi) {
		int p, q;
		int c = 0;
		int pivot = rand.nextInt(Math.max(hi - lo, 1)) + lo;
		double temp = arr.get(hi);
		arr.set(hi, arr.get(pivot));
		arr.set(pivot, temp);
		pivot = hi; //throw this stupid thing to the end of the array so I dont have to worry about it jstgrf phfhkigikf
		double val = arr.get(pivot);

		p = lo;
		q = hi;
		int AAAAAAAAAA = lo; //A stands for Anguish


		while(p<hi){
				if(screen!=null){
					count++;
					if(count%countfactor==0) {
						screen.pointer = p;
						screen.pn.repaint();
						try {
							TimeUnit.NANOSECONDS.sleep(timeouttime);
						} catch (InterruptedException ignored) {
						}
					}
				}
			if(p==pivot){
				continue;
			}else{
				if (arr.get(p) < val) {

					swap(arr, p, AAAAAAAAAA);	
					AAAAAAAAAA++;
				}
				else {
					//equal
					if (c++ % 2 == 0) {
					} else {
						swap(arr, p, AAAAAAAAAA);	
						AAAAAAAAAA++;
					}
				}
				p++;
			}
		}


			//for(int i=q; i<arr.length; i--){
			//	if(arr[i] == val){
			//		return i; //?????????????????????
			//	}
			//}
			//return -1;

			swap(arr, hi, AAAAAAAAAA);	
			if(screen!=null){
					count++;
					if(count%countfactor==0) {
						screen.pointer = p;
						screen.pn.repaint();
						try {
							TimeUnit.NANOSECONDS.sleep(timeouttime);
						} catch (InterruptedException ignored) {
						}
					}
				}
		return AAAAAAAAAA;
	}
	

	public static void quickSort(List<Double> data){
		quickSortWrap(data, 0, data.size()-1);
		quickSortWrap(data, 0, data.size()-1);
	}
	public static void quickSortWrap(List<Double> data, int lo, int hi){
		if(lo>=hi){
			return;
		}
		int v = partition(data, lo, hi);
		if(screen!=null){
					count++;
					if(count%countfactor==0) {
						screen.pointer = v;
						screen.pn.repaint();
						try {
							TimeUnit.NANOSECONDS.sleep(timeouttime);
						} catch (InterruptedException ignored) {
						}
					}
				}
		quickSortWrap(data, lo, v);
		quickSortWrap(data, v+1, hi);
	}

    public static void chimpsort(List<Double> data){
        int end = data.size() - 1;
        boolean flag = true;

        while (flag){
            flag = false; // so that after starting you have to check if something got swapped
            for (int i = 0; i < end; i++){
                if (data.get(i) > data.get(i + 1)){ // swap?
                    if(screen!=null){

                        count++;
                        if(count%countfactor==0) {
                            screen.pointer = i;
                            screen.pn.repaint();
                            try {
                                TimeUnit.NANOSECONDS.sleep(timeouttime);
                            } catch (InterruptedException ignored) {
                            }
                        }
                    }
                    Double temp = data.get(i + 1);
                    data.set(i + 1, data.get(i));
                    data.set(i, temp);
                    flag = true; // there was a swap
                }
            }
            end--;
        }
    }
    public static void bubblesort(List<Double> data){
        boolean FLAG = false;

        for(int i=1; i<data.size(); i++){
            FLAG = false;
            for(int j=0; j<data.size()-i; j++){
                //System.out.println("Checking " + data[j] " to " + data[j+1]);
                if(data.get(j) > data.get(j + 1)){
                    FLAG = true;
                    double temp = data.get(j);
                    //System.out.println("Swapping " + data[j] + " with " + data[j+1]);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);

                    if(screen!=null){

                        count++;
                        if(count%countfactor==0) {
                            screen.pointer = j;
                            screen.pn.repaint();
                            try {
                                TimeUnit.NANOSECONDS.sleep(timeouttime);
                            } catch (InterruptedException ignored) {
                            }
                        }
                    }
                }

            }
            if(!FLAG){

                return;
            }

        }
        if(screen!=null){
            screen.pn.repaint();
            try {
                TimeUnit.NANOSECONDS.sleep(timeouttime);
            } catch (InterruptedException ignored) {}
        }
    }

    /*Do not implement until directions are posted*/
    public static void selectionsort(List<Double> data){
        boolean FLAG = false;
        for(int i=0; i<data.size(); i++){
            FLAG = false;
            int index = 0;
            for(int j=0; j<data.size()-i; j++){
                if(data.get(j) > data.get(index)) {index = j; FLAG = true;/* System.out.println("Largest value so far: " + data[index]);*/}
            }
            //if(FLAG){
            double temp = data.get(index);
            //System.out.println("Swapping " + temp + " with " + data[data.length-1-i]);
            data.set(index, data.get(data.size() - 1 - i));
            data.set(data.size() - 1 - i, temp);
            if(screen!=null){
                count++;
                if(count%countfactor==0) {
                    screen.pointer = i;
                    screen.pn.repaint();
                    try {
                        TimeUnit.NANOSECONDS.sleep(timeouttime);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
            //}else{
            //	return;
            //}
        }


    }

    /*Do not implement until directions are posted*/
    /*public static void insertionsort(List<Double> data){
        if(data.size() < 2){return;}
        for(int i=1; i<data.size(); i++){
            if(data.get(i) < data.get(i - 1)){
                double num = data.get(i);
                int index = i-1;
                while(index >= 0 && data.get(index) > num){
                    data.set(index + 1, data.get(index)); //shift array to the right
                    index-=1;

                    if(screen!=null){

                        count++;
                        if(count%countfactor==0) {
                            screen.pointer = index;
                            screen.pn.repaint();
                            try {
                                TimeUnit.NANOSECONDS.sleep(timeouttime);
                            } catch (InterruptedException ignored) {
                            }
                        }
                    }
                }
                if(screen!=null){

                    count++;
                    if(count%countfactor==0) {
                        screen.pointer = i;
                        screen.pn.repaint();
                        try {
                            TimeUnit.NANOSECONDS.sleep(timeouttime);
                        } catch (InterruptedException ignored) {
                        }
                    }
                }
                //System.out.println("Swapping " + data[index+1] + " with " + num);
                data.set(index + 1, num); //insertion
                if(screen!=null){

                    count++;
                    if(count%countfactor==0) {
                        screen.pn.repaint();
                        try {
                            TimeUnit.NANOSECONDS.sleep(timeouttime);
                        } catch (InterruptedException ignored) {
                        }
                    }
                }
            }


        }


    }
    */

    public static void insertionsort(List<Double> data) {
        for (int i = 1; i<data.size(); i++) {
            for (int j = i-1; j>=0; j--) {
                if (data.get(j + 1) < data.get(j)) {
                    swap(data, j+1, j);
                    if(screen!=null){

                        count++;
                        if(count%countfactor==0) {
                            screen.pointer = j;
                            screen.pn.repaint();
                            try {
                                TimeUnit.NANOSECONDS.sleep(timeouttime);
                            } catch (InterruptedException ignored) {
                            }
                        }
                    }

                } else break;
            }
            if(screen!=null){

                count++;
                if(count%countfactor==0) {
                    screen.pointer = i;
                    screen.pn.repaint();
                    try {
                        TimeUnit.NANOSECONDS.sleep(timeouttime);
                    } catch (InterruptedException ignored) {
                    }
                }
            }


        }

    }

}
