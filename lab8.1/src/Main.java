public class Main {

    public static void main(String[] args) {

        RecipeI rec = new Recipe("Капли для глаз",10);
        RecipeI recEx = new RecipeExtension(rec);

        System.out.println(rec.getDate() + " дн.");
        System.out.println(recEx.getDate() + " дн.");
    }
}

interface RecipeI{
    int getDate();
}

class Recipe implements RecipeI{
    private final String use;
    private final int day;

    Recipe(String use, final int day){
        this.use = use;
        this.day = day;
    }

    @Override
    public int getDate(){
        return this.day;
    }
}

abstract class Decorator implements RecipeI{
    final RecipeI recipeI;

    protected Decorator(RecipeI recipeI){
        this.recipeI = recipeI;
    }
}

class RecipeExtension extends Decorator{
    protected RecipeExtension(RecipeI recipeI){
        super(recipeI);
    }

    @Override
    public int getDate(){
        return this.recipeI.getDate() + 7;
    }
}