package org.mockbukkit.mockbukkit.block.state;

import org.mockbukkit.mockbukkit.MockBukkit;
import org.mockbukkit.mockbukkit.WorldMock;
import org.mockbukkit.mockbukkit.block.BlockMock;
import org.mockbukkit.mockbukkit.block.state.BlockStateMock;
import org.mockbukkit.mockbukkit.block.state.SculkShriekerStateMock;
import org.bukkit.Material;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class SculkShriekerStateMockTest
{

	private WorldMock world;
	private BlockMock block;
	private SculkShriekerStateMock sculkSensor;

	@BeforeEach
	void setUp()
	{
		MockBukkit.mock();
		this.world = new WorldMock();
		this.block = world.getBlockAt(0, 10, 0);
		this.block.setType(Material.SCULK_SHRIEKER);
		this.sculkSensor = new SculkShriekerStateMock(this.block);
	}

	@AfterEach
	void teardown()
	{
		MockBukkit.unmock();
	}

	@Test
	void constructor_Material()
	{
		assertDoesNotThrow(() -> new SculkShriekerStateMock(Material.SCULK_SHRIEKER));
	}

	@Test
	void constructor_Material_WrongType_ThrowsException()
	{
		assertThrowsExactly(IllegalArgumentException.class, () -> new SculkShriekerStateMock(Material.BEDROCK));
	}

	@Test
	void constructor_Block()
	{
		assertDoesNotThrow(() -> new SculkShriekerStateMock(new BlockMock(Material.SCULK_SHRIEKER)));
	}

	@Test
	void constructor_Block_WrongType_ThrowsException()
	{
		assertThrowsExactly(IllegalArgumentException.class, () -> new SculkShriekerStateMock(new BlockMock(Material.BEDROCK)));
	}

	@Test
	void constructor_Clone_CopiesAllValues()
	{
		sculkSensor.setWarningLevel(3);

		SculkShriekerStateMock clone = new SculkShriekerStateMock(sculkSensor);

		assertEquals(3, clone.getWarningLevel());
	}

	@Test
	void setLastVibrationFrequency()
	{
		sculkSensor.setWarningLevel(3);

		assertEquals(3, sculkSensor.getWarningLevel());
	}

	@Test
	void getSnapshot_DifferentInstance()
	{
		assertNotSame(sculkSensor, sculkSensor.getSnapshot());
	}

	@Test
	void blockStateMock_Mock_CorrectType()
	{
		assertInstanceOf(SculkShriekerStateMock.class, BlockStateMock.mockState(block));
	}

}