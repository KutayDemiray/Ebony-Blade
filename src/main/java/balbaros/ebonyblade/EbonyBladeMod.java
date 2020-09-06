package balbaros.ebonyblade;

import balbaros.ebonyblade.init.ModBlocks;
import balbaros.ebonyblade.init.ModItems;
import balbaros.ebonyblade.init.ModRecipes;
import balbaros.ebonyblade.worldgen.OreGen;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_MINECRAFT_VERSIONS )
public class EbonyBladeMod {

    @Mod.Instance
    public static EbonyBladeMod instance;

    @EventHandler
    public void preInit( FMLPreInitializationEvent event ) {
        System.out.println( Reference.MOD_ID + " preinit" );
        ModItems.init();
        ModBlocks.init();
    }

    @EventHandler
    public void init( FMLInitializationEvent event ) {
        System.out.println( Reference.MOD_ID + " init" );
        ModRecipes.init();
        GameRegistry.registerWorldGenerator( new OreGen(), 0 ); 
    }

    @EventHandler
    public void postInit( FMLPostInitializationEvent event ) {
        System.out.println( Reference.MOD_ID + " postinit" );
    }

}
