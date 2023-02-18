package be.seeseemelk.mockbukkit.block.state;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Conduit;
import org.jetbrains.annotations.NotNull;

/**
 * Mock implementation of a {@link Conduit}.
 *
 * @see TileStateMock
 */
public class ConduitStateMock extends TileStateMock implements Conduit
{

	/**
	 * Constructs a new {@link ConduitStateMock} for the provided {@link Material}.
	 * Only supports {@link Material#CONDUIT}
	 *
	 * @param material The material this state is for.
	 */
	public ConduitStateMock(@NotNull Material material)
	{
		super(material);
		checkType(material, Material.CONDUIT);
	}

	/**
	 * Constructs a new {@link ConduitStateMock} for the provided {@link Block}.
	 * Only supports {@link Material#CONDUIT}
	 *
	 * @param block The block this state is for.
	 */
	protected ConduitStateMock(@NotNull Block block)
	{
		super(block);
		checkType(block, Material.CONDUIT);
	}

	/**
	 * Constructs a new {@link ConduitStateMock} by cloning the data from an existing one.
	 *
	 * @param state The state to clone.
	 */
	protected ConduitStateMock(@NotNull ConduitStateMock state)
	{
		super(state);
	}

	@Override
	public @NotNull ConduitStateMock getSnapshot()
	{
		return new ConduitStateMock(this);
	}

}