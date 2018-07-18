package fr.wolfdev.mineorm.container;

import fr.wolfdev.mineorm.orm.AnnotationMapping;
import fr.wolfdev.mineorm.orm.SavedToNBT;
import fr.wolfdev.mineorm.orm.TypeRegistration;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;

public class TileEntityORM extends TileEntity
{
    private final Map<Field, SavedToNBT> savedFields;

    public TileEntityORM()
    {
        super();
        savedFields = AnnotationMapping.getAnnotations(this.getClass()).collect(Collectors.toMap(f -> f, f -> f.getAnnotation(SavedToNBT.class)));
    }

    @Override
    public void markDirty()
    {
        super.markDirty();
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        savedFields.forEach((field, savedToNBT) -> {
            try
            {
                field.set(this, TypeRegistration.getMapping(savedToNBT.type()).read(compound, savedToNBT.key()));
            }
            catch(IllegalAccessException e)
            {
                e.printStackTrace();
            }
        });
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        savedFields.forEach((field, savedToNBT) -> {
            try
            {
                TypeRegistration.getMapping(savedToNBT.type()).genericWrite(compound, savedToNBT.key(), field.get(this));
            }
            catch(IllegalAccessException e)
            {
                e.printStackTrace();
            }
        });
        return compound;
    }
}
