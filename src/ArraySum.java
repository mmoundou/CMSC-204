class ArraySum // create class ArraySum
{
//implement sumOfArray() method with two arugments
//First argument Integer array a and Second argument int size
public int sumOfArray(Integer a[],int size)
{
if(size<=0) return 0; // check condition size<=0 then return 0
return sumOfArray(a,size-1)+a[size-1]; // else, call recusively sumOfArray() and calculate sum of array elements
}
}

