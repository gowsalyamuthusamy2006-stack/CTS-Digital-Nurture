class Product{
    int productId;
    String productName;
    String category;

    Product(int productId,String productName,String category){
        this.productId=productId;
        this.productName=productName;
        this.category=category;
    }

    public String toString(){
        return productId+" "+productName+" "+category;
    }
}

public class SearchDemo{

    public static Product linearSearch(Product[] products,int key){
        for(Product p:products){
            if(p.productId==key){
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products,int key){
        int low=0;
        int high=products.length-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(products[mid].productId==key)
                return products[mid];
            else if(products[mid].productId<key)
                low=mid+1;
            else
                high=mid-1;
        }
        return null;
    }

    public static void main(String[] args){

        Product[] linearArray={
            new Product(103,"Laptop","Electronics"),
            new Product(101,"Mobile","Electronics"),
            new Product(105,"Shoes","Fashion"),
            new Product(102,"Watch","Accessories"),
            new Product(104,"Bag","Fashion")
        };

        Product[] sortedArray={
            new Product(101,"Mobile","Electronics"),
            new Product(102,"Watch","Accessories"),
            new Product(103,"Laptop","Electronics"),
            new Product(104,"Bag","Fashion"),
            new Product(105,"Shoes","Fashion")
        };

        int searchId=104;

        Product result1=linearSearch(linearArray,searchId);

        if(result1!=null)
            System.out.println("Linear Search Result: "+result1);
        else
            System.out.println("Product Not Found");

        Product result2=binarySearch(sortedArray,searchId);

        if(result2!=null)
            System.out.println("Binary Search Result: "+result2);
        else
            System.out.println("Product Not Found");
    }
}