package balbaros.ebonyblade;

import balbaros.ebonyblade.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_MINECRAFT_VERSIONS )
public class EbonyBladeMod {

    @Mod.Instance
    public static EbonyBladeMod instance;

    @EventHandler
    public void preInit( FMLPreInitializationEvent event ) {
        System.out.println( Reference.MOD_ID + " preinit" );
        ModItems.init();
    }

    @EventHandler
    public void init( FMLInitializationEvent event ) {
        System.out.println( Reference.MOD_ID + " init" );
    }

    @EventHandler
    public void postInit( FMLPostInitializationEvent event ) {
        System.out.println( Reference.MOD_ID + " postinit" );
    }

}
