package fr.wolfdev.mineorm.orm;

import com.google.common.collect.Maps;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

import java.util.Map;
import java.util.Objects;

public class TypeRegistration
{
    private static final Map<String, INBTSerializable> mapping = Maps.newHashMap();

    public static void registerAll()
    {
        register("boolean", new INBTSerializable<Boolean>()
        {

            @Override
            public void write(NBTTagCompound tag, String key, Boolean value)
            {
                tag.setBoolean(key, value);
            }

            @Override
            public Boolean read(NBTTagCompound tag, String key)
            {
                return tag.getBoolean(key);
            }
        });
        register("byte", new INBTSerializable<Byte>()
        {

            @Override
            public void write(NBTTagCompound tag, String key, Byte value)
            {
                tag.setByte(key, value);
            }

            @Override
            public Byte read(NBTTagCompound tag, String key)
            {
                return tag.getByte(key);
            }
        });
        register("short", new INBTSerializable<Short>()
        {

            @Override
            public void write(NBTTagCompound tag, String key, Short value)
            {
                tag.setShort(key, value);
            }

            @Override
            public Short read(NBTTagCompound tag, String key)
            {
                return tag.getShort(key);
            }
        });
        register("int", new INBTSerializable<Integer>()
        {

            @Override
            public void write(NBTTagCompound tag, String key, Integer value)
            {
                tag.setInteger(key, value);
            }

            @Override
            public Integer read(NBTTagCompound tag, String key)
            {
                return tag.getInteger(key);
            }
        });
        register("long", new INBTSerializable<Long>()
        {

            @Override
            public void write(NBTTagCompound tag, String key, Long value)
            {
                tag.setLong(key, value);
            }

            @Override
            public Long read(NBTTagCompound tag, String key)
            {
                return tag.getLong(key);
            }
        });
        register("float", new INBTSerializable<Float>()
        {
            @Override
            public void write(NBTTagCompound tag, String key, Float value)
            {
                tag.setFloat(key, value);
            }

            @Override
            public Float read(NBTTagCompound tag, String key)
            {
                return tag.getFloat(key);
            }
        });
        register("double", new INBTSerializable<Double>()
        {
            @Override
            public void write(NBTTagCompound tag, String key, Double value)
            {
                tag.setDouble(key, value);
            }

            @Override
            public Double read(NBTTagCompound tag, String key)
            {
                return tag.getDouble(key);
            }
        });
        register("String", new INBTSerializable<String>()
        {
            @Override
            public void write(NBTTagCompound tag, String key, String value)
            {
                tag.setString(key, value);
            }

            @Override
            public String read(NBTTagCompound tag, String key)
            {
                return tag.getString(key);
            }
        });
    }

    public static void register(String name, INBTSerializable nbtSerializable)
    {
        if(!mapping.containsKey(name))
            mapping.put(name, Objects.requireNonNull(nbtSerializable, "nbtSerializable can not be null"));
    }

    public static INBTSerializable<?> getMapping(String name)
    {
        return (INBTSerializable<?>)mapping.get(name);
    }
}
