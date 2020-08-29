package balbaros.ebonyblade.items;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class CustomMaterial {

    /**
     * Ebony is better than diamond in combat stats and enchantability, but worse in durability and mining speed\n
     * Harvest Level: 4\n
     * Durability: 1024\n
     * Mining Speed: 10\n
     * Damage: 4\n
     * Enchantability: 18
     */
    public static final Item.ToolMaterial EBONY = EnumHelper.addToolMaterial( "EBONY", 4, 1024, 10.0f, 4.0f, 18  );

}
