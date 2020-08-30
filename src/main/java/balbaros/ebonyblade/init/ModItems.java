package balbaros.ebonyblade.init;

import balbaros.ebonyblade.Reference;
import balbaros.ebonyblade.items.ItemBasic;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

@Mod.EventBusSubscriber( modid = Reference.MOD_ID )
public class ModItems {
	
	public static final ArrayList<Item> MOD_ITEMS = new ArrayList<>();

    static Item crudeEbonite;

    public static void initItems() {
        crudeEbonite = new ItemBasic( "crude_ebonite" ).setCreativeTab( CreativeTabs.MISC );
        MOD_ITEMS.add( crudeEbonite );
    }

    static void registerRender( Item item ) {
        ModelLoader.setCustomModelResourceLocation( item, 0 , new ModelResourceLocation( item.getRegistryName(), "inventory" ) );
    }

    @SubscribeEvent
    public static void registerItems( RegistryEvent.Register<Item> event ) {
        event.getRegistry().registerAll( MOD_ITEMS.toArray( new Item[0] ) );
    }

    @SubscribeEvent
    public static void registerRenders( ModelRegistryEvent event ) {
    	for ( Item item : MOD_ITEMS ) {
    		registerRender( item );
    	}
    }

}
