package org.mockbukkit.mockbukkit.block.state;

import org.mockbukkit.mockbukkit.UnimplementedOperationException;
import org.mockbukkit.mockbukkit.inventory.BarrelInventoryMock;
import org.mockbukkit.mockbukkit.inventory.InventoryMock;
import org.bukkit.Material;
import org.bukkit.block.Barrel;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.loot.LootTable;
import org.jetbrains.annotations.NotNull;

/**
 * Mock implementation of a {@link Barrel}.
 *
 * @see ContainerStateMock
 */
public class BarrelStateMock extends ContainerStateMock implements Barrel
{

	private boolean isOpen = false;

	/**
	 * Constructs a new {@link BarrelStateMock} for the provided {@link Material}.
	 * Only supports {@link Material#BARREL}
	 *
	 * @param material The material this state is for.
	 */
	public BarrelStateMock(@NotNull Material material)
	{
		super(material);
		checkType(material, Material.BARREL);
	}

	/**
	 * Constructs a new {@link BarrelStateMock} for the provided {@link Block}.
	 * Only supports {@link Material#BARREL}
	 *
	 * @param block The block this state is for.
	 */
	protected BarrelStateMock(@NotNull Block block)
	{
		super(block);
		checkType(block, Material.BARREL);
	}

	/**
	 * Constructs a new {@link BarrelStateMock} by cloning the data from an existing one.
	 *
	 * @param state The state to clone.
	 */
	protected BarrelStateMock(@NotNull BarrelStateMock state)
	{
		super(state);
		this.isOpen = state.isOpen;
	}

	@Override
	public void setLootTable(LootTable table)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public LootTable getLootTable()
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public void setSeed(long seed)
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public long getSeed()
	{
		// TODO Auto-generated method stub
		throw new UnimplementedOperationException();
	}

	@Override
	public void open()
	{
		isOpen = true;
	}

	@Override
	public void close()
	{
		isOpen = false;
	}

	@Override
	public boolean isOpen()
	{
		return isOpen;
	}

	@Override
	protected @NotNull InventoryMock createInventory()
	{
		return new BarrelInventoryMock(this);
	}

	@Override
	public @NotNull BlockState getSnapshot()
	{
		return new BarrelStateMock(this);
	}

}