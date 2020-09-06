package balbaros.ebonyblade.init;

import balbaros.ebonyblade.Reference;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
	
	public static void init() {
		GameRegistry.addSmelting( ModBlocks.eboniteOre, new ItemStack( ModItems.crudeEbonite, 1 ), 1.2f );
		// add powder to crude ebonite recipe
	}
	
}
