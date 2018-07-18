package fr.wolfdev.mineorm.test;

import fr.wolfdev.mineorm.container.TileEntityORM;
import fr.wolfdev.mineorm.orm.SavedToNBT;
import net.minecraft.util.ITickable;

public class MyTile extends TileEntityORM implements ITickable
{

    @SavedToNBT(type = "int", key= "fr/wolfdev/mineorm/test")
    public int test = 0;

    @Override
    public void update()
    {
        test++;
        System.out.println(test);
    }
}
