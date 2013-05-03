package aginsun.taleofkingdoms.core.quests;

import java.awt.List;
import java.util.Map;
import java.util.TreeMap;

public class QuestRegistry 
{
	private static Map<Integer, Quest> QuestMap = new TreeMap();
	private static List QuestList = new List();
	
	public static void InitQuests()
	{
		registerQuest(new QuestGuildMaster(1, 0));
		registerQuest(new QuestGuildMaster(2, 1));
		registerQuest(new QuestGuildMaster(3, 2));
	}
	
	public static void registerQuest(Quest quest)
	{
		QuestMap.put(quest.QuestNumber, quest);
	}
	
	public static Quest getQuest(int QuestNumber)
	{
		return QuestMap.get(QuestNumber);
	}
}
