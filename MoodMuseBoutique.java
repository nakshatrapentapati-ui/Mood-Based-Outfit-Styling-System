import java.util.*;

class Outfit {

    String type;
    String style;
    String outfit;
    String shoes;
    String bag;
    String tip;

    Outfit(String type,String style,String outfit,String shoes,String bag,String tip){
        this.type=type;
        this.style=style;
        this.outfit=outfit;
        this.shoes=shoes;
        this.bag=bag;
        this.tip=tip;
    }
}

public class MoodMuseBoutique {

    // CO2 → List ADT using ArrayList
    static List<Outfit> outfits = new ArrayList<>();

    // CO4 → HashMap for fast lookup
    static HashMap<String, Outfit> outfitMap = new HashMap<>();

    // CO3 → Queue to store user requests
    static Queue<String> requestQueue = new LinkedList<>();


    static void addOutfits(){

        outfits.add(new Outfit(
                "indian","saree",
                "Elegant silk saree with matching blouse",
                "Traditional heels or juttis",
                "Embroidered clutch bag",
                "Style with jhumkas and bangles"
        ));

        outfits.add(new Outfit(
                "indian","lehenga",
                "Beautiful lehenga with embroidered dupatta",
                "Decorated ethnic heels",
                "Small potli bag",
                "Pair with statement earrings"
        ));

        outfits.add(new Outfit(
                "western","casual",
                "Crop top with blue jeans",
                "White sneakers",
                "Sling bag",
                "Keep accessories minimal"
        ));

        outfits.add(new Outfit(
                "indo","fusion",
                "Kurti with denim jeans",
                "Kolhapuri sandals",
                "Handcrafted sling bag",
                "Use oxidized jewelry"
        ));

        // Insert into HashMap
        for(Outfit o : outfits){
            outfitMap.put(o.type + "-" + o.style , o);
        }
    }

    // CO1 → Linear Search
    static Outfit linearSearch(String type,String style){

        for(Outfit o : outfits){
            if(o.type.equals(type) && o.style.equals(style)){
                return o;
            }
        }
        return null;
    }


    // CO1 → Sorting (Bubble Sort)
    static void sortOutfits(){

        for(int i=0;i<outfits.size()-1;i++){

            for(int j=0;j<outfits.size()-i-1;j++){

                if(outfits.get(j).style.compareTo(outfits.get(j+1).style) > 0){

                    Outfit temp = outfits.get(j);
                    outfits.set(j,outfits.get(j+1));
                    outfits.set(j+1,temp);
                }
            }
        }
    }


    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        addOutfits();

        System.out.println("🎀 MoodMuse Boutique 🎀");

        System.out.println("Select Outfit Type:");
        System.out.println("1. Indian");
        System.out.println("2. Western");
        System.out.println("3. Indo-Western");

        int typeChoice = sc.nextInt();
        sc.nextLine();

        String type="";

        if(typeChoice==1) type="indian";
        else if(typeChoice==2) type="western";
        else type="indo";

        System.out.println("Enter Style:");
        String style = sc.nextLine();

        // CO3 → store request in Queue
        requestQueue.add(type + "-" + style);

        // Process Queue
        String request = requestQueue.poll();

        // CO4 → HashMap lookup
        Outfit result = outfitMap.get(request);

        // If hashmap fails use linear search
        if(result == null){
            result = linearSearch(type,style);
        }

        // Sort outfits before displaying list
        sortOutfits();

        if(result!=null){

            System.out.println("\n✨ Your Styled Look ✨");

            System.out.println("Outfit : "+result.outfit);
            System.out.println("Shoes  : "+result.shoes);
            System.out.println("Bag    : "+result.bag);
            System.out.println("Styling Tip : "+result.tip);

        }
        else{

            System.out.println("No outfit found.");

        }

    }
}