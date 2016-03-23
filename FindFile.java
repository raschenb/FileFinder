import java.io.File;

public class FindFile
{
	public static String searchForFile(File dir, String target)
	{
		String result = "";

		// If dir is not a directory, return
		if (!dir.isDirectory())
			return "Path is not a directory.";

		// Check each item in the directory
		for (File folderItem : dir.listFiles())
		{
			// Recurse if it's a directory
			if (folderItem.isDirectory())
			{
				result = searchForFile(folderItem,target);
				// Exit if find a match; could comment out to keep searching
				if (!result.equals(""))
					return result;
			}
			// If it's a file, check for a match
			else
			{
				if (folderItem.getName().equals(target))
				{
					// Return first result found; could print instead and it
					// would show all matches if there are multiple matches
					return folderItem.getAbsolutePath();
				}
			}
		}
		// If we got here, nothing more was found
		return result;
	}

	public static void main(String[] args)
	{
		// The root folder to search
		File rootFolder = new File("C:\\homeworks\\");
		String result = searchForFile(rootFolder, "Target Filename");
		if (!result.equals(""))
			System.out.println(result);
		else
			System.out.println("End of search.");

	}
}