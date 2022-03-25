import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E> {

    private ArrayList<E> mArrList = new ArrayList<>();
    private int topOfStack = -1;

    @Override
    public boolean empty() {
        return mArrList.size() == 0;
    }

    @Override
    public E peek() {
        if (empty())
            { throw new EmptyStackException(); }

        return mArrList.get(topOfStack);
    }

    @Override
    public E pop() {
        if (empty())
            { throw new EmptyStackException(); }

        return mArrList.remove(topOfStack--);
    }

    @Override
    public E push(E obj) {
        mArrList.add(obj);
        topOfStack++;
        return obj;
    }
}