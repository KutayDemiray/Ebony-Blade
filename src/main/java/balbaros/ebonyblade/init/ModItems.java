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

    static Item crudeEbonite;

    public static void init() {
        crudeEbonite = new ItemBasic( "crude_ebonite" );
        crudeEbonite.setCreativeTab( CreativeTabs.MISC );
    }

    private static void registerRender( Item item ) {
        ModelLoader.setCustomModelResourceLocation( item, 0 , new ModelResourceLocation( item.getRegistryName(), "inventory" ) );
    }

    @SubscribeEvent
    public static void registerItems( RegistryEvent.Register<Item> event ) {
        event.getRegistry().registerAll( crudeEbonite );
    }

    @SubscribeEvent
    public static void registerModels( ModelRegistryEvent event ) {
        registerRender( crudeEbonite );
    }

}
