# Vinii's Variants Mod (V2M)

<img height="300" src="https://github.com/ViniiR/Variants-Mod/blob/master/src/main/resources/assets/v2m/icon.png"
    alt="V2M logo">

## Features

### Mobs
Added several mob variants
#### Overworld

Icid Zombie spawns in specific snowy biomes

Frozen Guardians spawn on cold oceans ocean monuments (TODO: update texture)

#### Nether

Soul Skeletons spawn on soul sand valleys

Soul Blazes spawn on soul sand valleys

Warped Endermen spawn on warped forests

#### Summoned

Pale Snow Golems can be spawned with pale pumpkins

### Crafting Table variants

added 11 crafting table variants


### Chest variants

added 11 wood chest variants (and 11 trapped chests)


### Barrel variants

added 11 barrel variants


### Furnace variants

added 2 furnace variants


### Glass panes

Glass panes placed in all snowy biomes become frosted (can be ignored if crouching while placing)


### Pale Pumpkins

Pale pumpkins naturally spawn in Pale Gardens, they behave as a normal pumpkin but spawn Pale Snow Golems and can be
Farmed TODO: cannot be farmed since there aren't seeds yet

TODO: create seeds

### Structures

All structures generate with biome and dimension based variant utility blocks, see <b>getReplacedBlock</b> in
<a href="https://github.com/ViniiR/Variants-Mod/blob/master/src/main/java/com/vinii/v2m/world/structure/VariantsStructureProcessor.java?plain=1">
    here
</a>
and the <b>variant biome tags</b> in
<a href="https://github.com/ViniiR/Variants-Mod/blob/master/src/main/java/com/vinii/v2m/datagen/tag/ModBiomeTagProvider.java?plain=1">
    here
</a>

The end dimension is not affected by this at all.

<ul>
    <li>
        Snowy villages generate with frosted glass panes instead of glass panes  
    </li>
    <li>
        Woodland mansions generated in Pale gardens are made of pale oak  
    </li>
    <li>
        Nether fortresses generate with red nether bricks in crimson forests (TODO:)
    </li>
</ul>

## Additional features

<ul>
    <!-- Chests -->
    <li>Donkeys and Mules accept Modded chests</li>
    <li>Copper golems look for Modded Chests</li>
    <!-- Pumpkins -->
    <li>Carved Pale Pumpkins spawn Iron, Copper, and pale snow golems (also with dispensers)</li>
    <li>Pale pumpkins are valid composter items</li>
    <li>Carved Pale Pumpkin can be equipped in your head, enchanted, and endermen ignore you</li>
    <li>Endermen can grab pale pumpkins</li>
    <li>Piglins are scared of Pale Jack o' Lanterns</li>
    <li>Wandering trader sells pale pumpkins</li> TODO:
    <li>Farmers buy pale pumpkins for emeralds</li> TODO:
    <!-- Barrels -->
    <li>Mod barrels are valid fisherman profession sites</li>
</ul>

## Additional vanilla changes

<ul>
    <li>Chest (& Trapped), Crafting table, Barrel and Furnace have been retextured and renamed to their now new variant
    </li>
    <li>All Copper chest containers have been renamed from "Chest" -> "Copper Chest"</li>
    <li>Modified several vanilla recipes (related to item variants)(mostly to include the recipes in a group)</li>
</ul>

## Known issues

<ul>
    <li>Oak Chest(Vanilla Chest) break particles display chest.png instead of oak_planks.png</li>
    <li>Large structure's (like mansions) chests generate on a different biome and possibly with awkward rotation TODO: WIP (has internal todo message)</li>
</ul>
