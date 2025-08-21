package com.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ESF implements ModInitializer {

    public static final String MOD_ID = "esf";

    // Вкладка предметів мода
    private static final RegistryKey<ItemGroup> ESF_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            Identifier.of(MOD_ID, "group"));

    // Сам веник
    private static final Venik VENIK = Registry.register(Registries.ITEM, Identifier.of("esf:venik"),
            new Venik(new Item.Settings().maxCount(1)));

    @Override
    public void onInitialize() {
        // Реєстрація вкладки
        Registry.register(Registries.ITEM_GROUP, ESF_GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable("itemGroup." + MOD_ID + ".group"))
                .icon(() -> new ItemStack(VENIK))
                .entries((context, entries) -> {entries.add(VENIK);}).build());
    }
}
