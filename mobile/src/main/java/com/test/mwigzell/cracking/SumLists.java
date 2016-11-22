package com.test.mwigzell.cracking;

/**
 * Created by mark on 11/20/16.
 */

public class SumLists {
    int getReverseVal(LinkListNode<Integer> val) {
        LinkListNode<Integer> node = val;
        int column = 0;
        int sum = 0;
        while(node != null) {
            sum += node.data * (int)Math.pow(10, column);
            node = node.next;
            column++;
        }
        return sum;
    }

    LinkListNode<Integer> buildResult(int sum) {
        LinkListNode<Integer> result = null;
        LinkListNode<Integer> resultEnd = result;
        String sumValue = Integer.toString(sum);
        for (int i = sumValue.length() -1; i >= 0; i--) {
            LinkListNode<Integer> sumDigit = new LinkListNode<>(Character.getNumericValue(sumValue.charAt(i)));
            if (result == null) {
                resultEnd = sumDigit;
                result = resultEnd;
            } else {
                resultEnd.next = sumDigit;
                resultEnd = resultEnd.next;
            }
        }

        return result;
    }

    public LinkListNode<Integer> sumReverse(LinkListNode<Integer> val1, LinkListNode<Integer> val2) {
        int sum = getReverseVal(val1) + getReverseVal(val2);
        return buildResult(sum);
    }

    int getVal(LinkListNode<Integer> val, int sum, int column) {
        if (val == null) {
            return sum;
        } else {
            sum += val.data * (int)Math.pow(10, column);
            return getVal(val.next, sum, column + 1);
        }
    }

    public LinkListNode<Integer> sum(LinkListNode<Integer> val1, LinkListNode<Integer> val2) {
        int sum = getVal(val1, 0, 0) + getVal(val2, 0, 0);
        return buildResult(sum);
    }
}
