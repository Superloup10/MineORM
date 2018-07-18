package fr.wolfdev.mineorm.test;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MineORM.MOD_ID)
public class Blocks
{
    public static final Block block = new BlockTmp().setRegistryName("block_tmp").setUnlocalizedName("block_tmp");

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(block);
    }

    @SubscribeEvent
    public static void registreItem(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerModel(ModelRegistryEvent event)
    {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Item.getItemFromBlock(block).getRegistryName(), "inventory"));
    }
}
