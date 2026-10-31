import java.util.Scanner;
import java.util.Random;
void main() {
    int i=0;
    Random random=new Random();
    Scanner scanner = new Scanner(System.in);

////       Циклический сдвиг. Массив из 10 элементов сдвинуть вправо на k позиций (k вводит пользователь). Пример: 1 2 3 4 5, k=2 → 4 5 1 2 3.

    int[] cyclicShift=new int[10];
    for (i=0; i<cyclicShift.length; i++){
        cyclicShift[i]= random.nextInt(0, 20);
        System.out.print(cyclicShift[i]+" ");
    }
    System.out.print("\n");
    System.out.print("Введите число сдвига в право - k: ");
    int n = cyclicShift.length;
    int k = scanner.nextInt();
    int[] temp = new int[n];
    for (i = 0; i < n; i++) {
        temp[(i + k) % n] = cyclicShift[i];
    }
    System.out.print("Сдвиг вправо на k позиций: \n");
    for (i = 0; i < n; i++) {
        cyclicShift[i] = temp[i];
        System.out.print(cyclicShift[i]+" ");
    }

    System.out.print("\n");
    System.out.println("--------------------------------------------");

////       Второй максимум. Найти второе по величине число в массиве из 12 случайных чисел без сортировки, за один проход.

    int[] secondMaximum=new int[12];
    int max = 0;
    int secondMax =0;
    for (i=0; i<secondMaximum.length; i++){
        secondMaximum[i]= random.nextInt(-10, 100);
        System.out.print(secondMaximum[i]+" ");
    }
    System.out.print("\n");
    for (int num : secondMaximum){
        if (num > max) {
            secondMax = max;
            max = num;
        } else if (num > secondMax && num != max) {
            secondMax = num;
        }
    }
    System.out.println("Наибольшее число: " + max);
    System.out.println("Второе по величине число: " + secondMax);


    System.out.print("\n");
    System.out.println("--------------------------------------------");

////       Палиндром. Ввести массив из 7 чисел и проверить, читается ли он одинаково слева направо и справа налево (1 2 3 2 1 → да).

    int[] palindrome = new int[7];
    System.out.println("Введите 7 чисел:");
    for (i = 0; i < palindrome.length; i++) {
        System.out.print("Число " + (i + 1) + ": ");
        palindrome[i] = scanner.nextInt();
    }
    boolean isPalindrome = true;
    for (i = 0; i < palindrome.length / 2; i++) {
        if (palindrome[i] != palindrome[palindrome.length - 1 - i]) {
            isPalindrome = false;
            break;
        }
    }
    if (isPalindrome) {
        System.out.println("Да, массив  палиндром.");
    } else {
        System.out.println("нет, массив не палиндром.");
    }

    System.out.print("\n");
    System.out.println("--------------------------------------------");

////       Уникальные элементы. Заполнить массив из 15 элементов случайными числами от 1 до 10 и вывести каждое число только один раз.

    int[] uniqueElements = new int[15];
    System.out.print("Исходный массив: ");
    for (i = 0; i < uniqueElements.length; i++) {
        uniqueElements[i] = random.nextInt(11);
        System.out.print(uniqueElements[i] + " ");
    }
    System.out.println();

    System.out.print("Уникальные элементы: ");
    for (i = 0; i < uniqueElements.length; i++) {
        boolean isDuplicate = false;

        for (int j = 0; j < i; j++) {
            if (uniqueElements[i] == uniqueElements[j]) {
                isDuplicate = true;
                break;
            }
        }

        if (!isDuplicate) {
            System.out.print(uniqueElements[i] + " ");
        }
    }

    System.out.print("\n");
    System.out.println("--------------------------------------------");

////       Самый частый элемент. В массиве из 20 случайных чисел от 1 до 5 найти число, которое встречается чаще всего, и сколько раз.

    int[] mostFrequentElement = new int[20];
    System.out.print("Исходный массив: ");
    for (i = 0; i < mostFrequentElement.length; i++) {
        mostFrequentElement[i] = random.nextInt(1, 5);
        System.out.print(mostFrequentElement[i] + " ");
    }

    int[] counts=new int[6];
    for(int num:mostFrequentElement){
        counts[num]++;
    }
    int mostFrequentNumber = 1;
    int maxCount = counts[1];

    for (i = 2; i <= 5; i++) {
        if (counts[i] > maxCount) {
            maxCount = counts[i];
            mostFrequentNumber = i;
        }
    }
    System.out.print("\n");
    System.out.println("Число, которое встречается чаще всего: " + mostFrequentNumber);
    System.out.println("Количество повторений: " + maxCount);

    System.out.print("\n");
    System.out.println("--------------------------------------------");

////       Возрастающая серия. Найти длину самой длинной подряд идущей возрастающей последовательности. 3 1 2 5 7 2 4 → 1 2 5 7, длина 4.

    int[] increasingSeries = new int[10];
    System.out.print("Исходный массив: ");
    for (i = 0; i < increasingSeries.length; i++) {
        increasingSeries[i] = random.nextInt(-20, 20);
        System.out.print(increasingSeries[i] + " ");
    }
    System.out.print("\n");

    int maxLen = 1;
    int currentLen = 1;
    int maxEndIndex = 0;

    for (i = 0; i < increasingSeries.length - 1; i++) {
        if (increasingSeries[i + 1] > increasingSeries[i]) {
            currentLen++;
        } else {
            if (currentLen > maxLen) {
                maxLen = currentLen;
                maxEndIndex = i;
            }
            currentLen = 1;
        }
    }
    if (currentLen > maxLen) {
        maxLen = currentLen;
        maxEndIndex = increasingSeries.length - 1;
    }

    int[] resultSlice = new int[maxLen];

    int startIndex = maxEndIndex - maxLen + 1;
    for (i = 0; i < maxLen; i++) {
        resultSlice[i] = increasingSeries[startIndex + i];
        System.out.print(resultSlice[i]+" ");

    }
    System.out.print("\n");
    System.out.println("Длина последовательности: " + maxLen);

    System.out.print("\n");
    System.out.println("--------------------------------------------");

////       Пара с суммой. Найти все пары элементов, сумма которых равна числу S, введённому пользователем. Каждую пару вывести один раз.

    int[] pairWithASum={1, 4, 0, 3, 2, 3, 1, 1, 4, 5};

    for (i=0; i<pairWithASum.length; i++){
        System.out.print(pairWithASum[i]+" ");
    }
    System.out.print("\n");
    System.out.print("Введите число: ");
    int s = scanner.nextInt();
    for (i=0; i<pairWithASum.length-1; i++){
        if(pairWithASum[i]+pairWithASum[i+1]==s){
            System.out.println(pairWithASum[i]+"+"+pairWithASum[i+1]+"="+s);
        }
    }

    System.out.print("\n");
    System.out.println("--------------------------------------------");

////       Перестановка по знаку. Переставить элементы так, чтобы сначала шли отрицательные, потом нули, потом положительные, сохраняя исходный порядок внутри каждой группы.


    int[] permutationBySign = {-21, 1, 4, 0, -2, 3, 0, 2, 3, 1, -1, 0, 4, 5};
    System.out.print("Исходный массив: ");
    for (i = 0; i < permutationBySign.length; i++) {
        System.out.print(permutationBySign[i] + " ");
    }
    System.out.print("\n");

    int[] result = new int[permutationBySign.length];
    int index = 0;

    for (i = 0; i < permutationBySign.length; i++) {
        if(permutationBySign[i]<0){
            result[index] = permutationBySign[i];
            index++;
        }
    }

    for (i = 0; i < permutationBySign.length; i++) {
        if(permutationBySign[i]==0){
            result[index] = permutationBySign[i];
            index++;
        }
    }

    for (i = 0; i < permutationBySign.length; i++) {
        if(permutationBySign[i]>0){
            result[index] = permutationBySign[i];
            index++;
        }
    }
    System.out.println(Arrays.toString(result));

    System.out.print("\n");
    System.out.println("--------------------------------------------");

////       Слияние массивов. Даны два отсортированных массива (5 и 6 элементов). Слить их в третий массив из 11 элементов, тоже отсортированный, без повторной сортировки.

    int[] arr = {-5,0,1,1,2};
    int[] arr2 = {-10,2,3,6,7,7};
    int[] arr3 = new int[arr.length + arr2.length];
    int m=0, j = 0, p = 0;
    while (m < arr.length || j < arr2.length) {
        if (m < arr.length && j < arr2.length) {
            if (arr[m] <= arr2[j]) {
                arr3[p++] = arr[m++];
            } else {
                arr3[p++] = arr2[j++];
            }
        } else if (m <arr.length) {
            arr3[p++] = arr[m++];
        } else {
            arr3[p++] = arr2[j++];
        }
    }
    System.out.print("\nПервый массив: ");
    for (m=0; m<arr.length; m++){
        System.out.print(arr[m]+" ");
    }
    System.out.print("\nВторой массив: ");
    for (j=0; j<arr2.length; j++){
        System.out.print(arr2[j]+" ");
    }
    System.out.print("\nОбъеденённый массив: ");
    for (p=0; p<arr3.length; p++){
        System.out.print(arr3[p]+" ");
    }

    System.out.print("\n");
    System.out.println("--------------------------------------------");

////       Бинарный поиск. В отсортированном массиве из 16 элементов найти заданное число бинарным поиском и вывести, за сколько шагов оно нашлось.

    int[] binarySearch = {-10, -5, 0,  1, 2, 3, 6, 7, 7, 8, 9, 11, 22, 45, 89, 93};
    int target = 9;
    for (i=0; i<binarySearch.length; i++){
        System.out.print(binarySearch[i]+" ");
    }
    int left = 0;
    int right = binarySearch.length - 1;
    int steps = 0;
    int foundIndex = -1;
    System.out.print("\n");
    while (left <= right) {
        steps++;
        int mid = left + (right - left) / 2;
        if (binarySearch[mid] == target) {
            foundIndex = mid;
            break;
        }
        if (binarySearch[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    if (foundIndex != -1) {
        System.out.println("Число: " + target + " найдено на индексе: " + foundIndex);
        System.out.println("Количество шагов: " + steps);
    } else {
        System.out.println("Число: " + target + " не найдено в массиве.");
        System.out.println("Количество шагов: " + steps);
    }
}
