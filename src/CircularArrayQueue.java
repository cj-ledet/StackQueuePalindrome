//Helpful Resources used while building out this data structure:
//Stacks & Queue/Deque
//https://youtu.be/A3ZUpyrnCbM
//Circular Arrays
//https://youtu.be/8sjFA-IX-Ww

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CircularArrayQueue<E> implements Queue<E> {

    //Fields
    private E[] mArr;
    private int mFront, mRear;

    //TODO: uncomment suppression below
    //@SuppressWarnings("unchecked")

    //Constructor
    public CircularArrayQueue(int capacity) {
        mFront = mRear = -1;

        //Because we cannot use generics here to instantiate our array
        //We will instead type cast with generics
        mArr = (E[]) new Object[capacity];
    }

    //Default constructor
    public CircularArrayQueue() {
        this(10); //Default size 10
    }

    @Override
    public boolean offer(E e) {
        if (isFull())
            resize();
        else if (isEmpty())
            mFront++;

        mRear = (mRear + 1) % mArr.length;
        mArr[mRear] = e;
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty())
            throw new NoSuchElementException();

        E temp = mArr[mFront];
        if (mFront == mRear)
            clear();
        else
            mFront = (mFront + 1) % mArr.length;
        return temp;
    }

    @Override
    public E poll() {
        if (isEmpty())
            return null;

        E temp = mArr[mFront];
        if (mFront == mRear)
            clear();
        else
            mFront = (mFront + 1) % mArr.length;
        return temp;
    }

    @Override
    public E element() {
        if (isEmpty())
            throw new NoSuchElementException();

        return mArr[mFront];
    }

    @Override
    public E peek() {
        if (isEmpty())
            return null;

        return mArr[mFront];
    }

    //Implemented Queue Methods
    @Override
    public int size() {
        return mArr.length;
    }

    @Override
    public boolean isEmpty() {
        return mFront == -1;
    }

    @Override
    public void clear() {
        mFront = mRear = -1;
    }
    //===================================
    //Extra helper methods
    public boolean isFull() {
        return (mRear + 1) % mArr.length == mFront;
    }

    public void resize() {
        //As mentioned before, as we cannot instantiate with generics, we instead type cast
        E[] tempArr = (E[]) new Object[mArr.length * 2];
        int i = 0, j = 0;

        do {
            tempArr[i++] = mArr[j];
            j = (j + 1) % mArr.length;
        } while (j != mFront);

        mFront = 0;
        mRear = mArr.length - 1;
        mArr = tempArr;
    }
    //===================================

    //Unchanged Methods
    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean add(E e) {
        if (isFull())
            resize();
        else if (isEmpty())
            mFront++;

        mRear = (mRear + 1) % mArr.length;
        mArr[mRear] = e;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
