package aginsun.taleofkingdoms.entities;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import aginsun.taleofkingdoms.api.ExperienceKeeper;
import aginsun.taleofkingdoms.api.QuestHandler;
import aginsun.taleofkingdoms.client.guis.GuiQuest;
import aginsun.taleofkingdoms.core.quests.Quest;
import aginsun.taleofkingdoms.core.quests.QuestGuildMaster;
import aginsun.taleofkingdoms.core.quests.QuestRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityGuildMaster extends EntityCreature
{
	public World world;
	public Quest quest;
	
	public EntityGuildMaster(World par1World) 
	{
		super(par1World);
		world = par1World;
		texture = "/aginsun/textures/head.png";
		moveSpeed = 0.0F;
		isImmuneToFire = false;
		health = 25;
	}

	@Override
	public int getMaxHealth() 
	{
		return 150;
	}
	
	protected boolean canDespawn()
	{
		return false;
	}
	
	public boolean canInteractWith(EntityPlayer player)
	{
		if(isDead)
		{
			return false;
		}
		else
		{
			return player.getDistanceSqToEntity(this) <= 64D;
		}
	}
	
	public boolean canBePushed()
	{
		return false;
	}
	
	public boolean isMovementCeased()
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean interact(EntityPlayer player)
	{
		if(canInteractWith(player))
		{
			if(QuestHandler.getQuestStatus(player, "The beginning of a great adventure") != 3)
				quest = QuestRegistry.getQuest(1).setPlayer(player);
			else if(QuestHandler.getQuestStatus(player, "Leveling") != 3)
				quest = QuestRegistry.getQuest(2).setPlayer(player);
			else if(QuestHandler.getQuestStatus(player, "") != 3)
				quest = QuestRegistry.getQuest(3).setPlayer(player);
			quest.update();
		}
		return true;
	}
}
