package fr.wolfdev.mineorm.test;

import fr.wolfdev.mineorm.orm.TypeRegistration;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MineORM.MOD_ID, name = MineORM.MOD_NAME, version = MineORM.VERSION)
public class MineORM
{
    public static final String MOD_ID = "mineorm";
    public static final String MOD_NAME = "MineORM";
    public static final String VERSION = "1.0-SNAPSHOT";

    @Mod.Instance(MOD_ID)
    public static MineORM INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        TypeRegistration.registerAll();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerTileEntity(MyTile.class, new ResourceLocation(MOD_ID, "myTile"));
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {

    }
}
