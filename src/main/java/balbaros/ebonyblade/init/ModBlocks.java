package balbaros.ebonyblade.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.Random;

import balbaros.ebonyblade.Reference;
import balbaros.ebonyblade.blocks.BlockBasic;
import balbaros.ebonyblade.blocks.BlockOre;

@Mod.EventBusSubscriber( modid = Reference.MOD_ID )
public class ModBlocks {
	
	public static Block eboniteOre;
	public static Block eboniteBlock;
	
	public static void initBlocks() {
		eboniteBlock = new BlockBasic( "ebonite_block", Material.ROCK ).setCreativeTab( CreativeTabs.BUILDING_BLOCKS ).setHardness( 3.0f );
		eboniteBlock.setHarvestLevel( "pickaxe", 3 );
		
		eboniteOre = new BlockOre( "ebonite_ore", Material.ROCK, ModItems.crudeEbonite, 1, 1 ).setCreativeTab( CreativeTabs.BUILDING_BLOCKS ).setHardness( 3.0f );
		eboniteOre.setHarvestLevel( "pickaxe", 3 );
        System.out.println( Reference.MOD_ID + "Ebonite Ore drop: " + eboniteOre.getItemDropped( eboniteOre.getDefaultState(), new Random(), 0 ).getRegistryName() );
	}
	
	@SubscribeEvent
	public static void registerBlocks( RegistryEvent.Register<Block> event ) {
		IForgeRegistry<Block> r = event.getRegistry();
		
		r.register( eboniteOre );
		r.register( eboniteBlock );
	}
	
	@SubscribeEvent
	public static void registerItemBlocks( RegistryEvent.Register<Item> event ) {
		IForgeRegistry<Item> r = event.getRegistry();
		
		r.register( new ItemBlock( eboniteOre ).setRegistryName( eboniteOre.getRegistryName() ) );
		r.register( new ItemBlock( eboniteBlock ).setRegistryName( eboniteBlock.getRegistryName() ) );
	}
	
	@SubscribeEvent
	public static void registerRenders( ModelRegistryEvent event ) {
		
		ModItems.registerRender( Item.getItemFromBlock( eboniteOre ) );
		ModItems.registerRender( Item.getItemFromBlock( eboniteBlock) );
		
	}
	
}
