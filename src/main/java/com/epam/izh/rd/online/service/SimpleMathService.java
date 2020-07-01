package com.epam.izh.rd.online.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {

        if (value1==value2) {
            return 0;
        } else if (value1<value2){
            return -1;
        } else {
            return 1;
        }

    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {

        if (value1<value2) {
            return value2;
        } else {
            return value1;
        }

    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {

        int maxValue = Integer.MIN_VALUE;
        for (int value: values) {
            maxValue = maxFrom(maxValue, value);
        }
        return maxValue;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {

        int sumValue = 0;
        for (int value: values) {
            sumValue += value;
        }
        return sumValue;

    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {

        int[] resArray = new int[values.length];
        int count = 0;

        for (int value: values) {
            if (value%2==0){
                resArray[count++]=value;
            }
        }

        return Arrays.copyOf(resArray, count) ;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {

        long result = 1;
        for (int i=1;i<=initialVal;i++){
            result*=i;
        }
        return result;

    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {

        long result = 0;
        long last = 1;
        long _temp = 0;

        for (int i=1;i<=number;i++){
            _temp = result;
            result += last;
            last = _temp;
        }
        return result;

    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {

//        int last = values.length;
//
//        for ( boolean sorted = last == 0; !sorted; --last )
//        {
//            sorted = true;
//            for ( int i = 1; i < last; ++i )
//            {
//                if ( values[i-1] < values[i] )
//                {
//                    sorted = false;
//
//                    int tmp = values[i-1];
//                    values[i-1] = values[i];
//                    values[i] = tmp;
//                }
//            }
//        }
        Arrays.sort(values);
        return values;

    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {

        boolean result = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                result = false;
            }
        }
        return result;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {

        int length = values.length;
        int[] resArray = new int[length];

        for(int i=0;i<length;i++) {
            resArray[length-1-i] = values[i];
        }

        return resArray;

    }
}
