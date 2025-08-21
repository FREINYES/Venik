package com.example;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.minecraft.block.Block;

public class Venik extends Item {

    public Venik(Settings settings) {super(settings);}

    // ПКМ по блоку → чистимо сніг
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block block = world.getBlockState(context.getBlockPos()).getBlock();

        if (world.isClient)
            return super.useOnBlock(context);
        if (block == Blocks.SNOW || block == Blocks.SNOW_BLOCK) {
            world.breakBlock(context.getBlockPos(), false); // чистимо без дропа
            return ActionResult.SUCCESS;
        }
        return super.useOnBlock(context);
    }
}