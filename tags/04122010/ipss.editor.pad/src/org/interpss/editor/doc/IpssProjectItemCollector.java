package org.interpss.editor.doc;

import java.util.ArrayList;

public abstract class IpssProjectItemCollector {
	private ArrayList<IpssProjectItem> projectItems = new ArrayList<IpssProjectItem>();

	public IpssProjectItem[] getAllProjectItems() {
		if (projectItems != null && projectItems.size() > 0) {
			return projectItems
					.toArray(new IpssProjectItem[projectItems.size()]);
		}
		return null;
	}

	public IpssProjectItem getItem(String itemname) {

		for (int i = 0; i < projectItems.size(); i++) {
			if (projectItems.get(i).getName().equalsIgnoreCase(itemname))
				return projectItems.get(i);
		}
		return null;
	}

	public ArrayList<IpssDocument> getAllOpenedDocuments() {
		ArrayList<IpssDocument> docs = new ArrayList<IpssDocument>();

		if (projectItems != null && projectItems.size() > 0) {
			for (int i = 0; i < projectItems.size(); i++) {
				if (projectItems.get(i).isLoaded())
					docs.add(projectItems.get(i).getDocument());
				if (projectItems.get(i).getItemCount() > 0) {
					docs.addAll(projectItems.get(i).getAllOpenedDocuments());
				}
			}
		}
		return docs;
	}

	public void addDocument(IpssDocument doc, int projDbId) {
		projectItems.add(new IpssProjectItem(getProject(), projDbId, doc));
	}

	public IpssProjectItem addDocument(String itemName, int projDbId,
			String status) {
		IpssProjectItem item = new IpssProjectItem(getProject(), projDbId,
				itemName, status);
		projectItems.add(item);
		return item;
	}

	public boolean closeDocument(IpssDocument d) {
		if (projectItems != null && projectItems.size() > 0) {
			for (int i = 0; i < projectItems.size(); i++) {

				if ((projectItems.get(i).isLoaded())
						&& (projectItems.get(i).getDocument().equals(d))) {
					projectItems.get(i).clearDocument();
					return true;
				}
				if (projectItems.get(i).getItemCount() > 0) {
					if (projectItems.get(i).closeDocument(d))
						return true;
				}
			}
		}
		return false;
	}

	public void removeProjectItem(IpssProjectItem item) {
		projectItems.remove(item);
	}

	public int getItemCount() {
		return projectItems.size();
	}

	public abstract IpssProject getProject();
}
