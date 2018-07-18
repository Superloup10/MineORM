package fr.wolfdev.mineorm.test;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockTmp extends Block
{
    public BlockTmp()
    {
        super(Material.ROCK);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new MyTile();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
