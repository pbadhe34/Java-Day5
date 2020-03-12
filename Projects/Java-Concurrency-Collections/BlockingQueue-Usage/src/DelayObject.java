 

import com.google.common.primitives.Ints;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/*The Delayed is mix-in style interface for marking objects that should be acted upon after a given delay. 

An implementation of this interface must define a compareTo method that provides an ordering consistent with its
getDelay method.*/


public class DelayObject implements Delayed {
    private String data;
    private long startTime;

    DelayObject(String data, long delayInMilliseconds) {
        this.data = data;
        this.startTime = System.currentTimeMillis() + delayInMilliseconds;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Ints.saturatedCast(this.startTime - ((DelayObject) o).startTime);
    }

    @Override
    public String toString() {
        return "{" + "data='" + data + '\'' + ", startTime=" + startTime + '}';
    }
}