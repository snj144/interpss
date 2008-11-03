package com.interpss.workbench;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class IpssAppActionBarAdvisor extends ActionBarAdvisor {

//	private IWorkbenchAction exitAction;
//	private IWorkbenchAction newAction;
//	private IWorkbenchAction aboutAction;

	private IWorkbenchAction aboutAction;
	private IWorkbenchAction dynamicHelpAction;
	private IWorkbenchAction helpSearchAction;
	private IWorkbenchAction helpContentsAction;
//	private IWorkbenchAction introAction;
	private IWorkbenchAction lockToolBarAction;
	private IWorkbenchAction previousPerspectiveAction;
	private IWorkbenchAction nextPerspectiveAction;
	private IWorkbenchAction previousPartAction;
	private IWorkbenchAction nextPartAction;
	private IWorkbenchAction showWorkbookEditorsAction;
	private IWorkbenchAction showOpenEditorsAction;
	private IWorkbenchAction previousEditorAction;
	private IWorkbenchAction nextEditorAction;
	private IWorkbenchAction activateEditorAction;
	private IWorkbenchAction minimizeAction;
	private IWorkbenchAction maximizeAction;
	private IWorkbenchAction showPartPaneMenuAction;
	private IWorkbenchAction closeAllPerspectivesAction;
	private IWorkbenchAction closePerspectiveAction;
	private IWorkbenchAction resetPerspectiveAction;
	private IWorkbenchAction savePerspectiveAction;
	private IWorkbenchAction editActionSetsAction;
	private IWorkbenchAction showViewMenuAction;
	private IWorkbenchAction openPerspectiveDialogAction;
	private IWorkbenchAction newEditorAction;
	private IWorkbenchAction openNewWindowAction;
	private IWorkbenchAction preferencesAction;
	private IWorkbenchAction forwardHistoryAction;
	private IWorkbenchAction backwardHistoryAction;
	private IWorkbenchAction forwardAction;
	private IWorkbenchAction previousAction;
	private IWorkbenchAction upAction;
	private IWorkbenchAction backAction;
	private IWorkbenchAction nextAction;
	private IWorkbenchAction goIntoAction;
	private IWorkbenchAction findAction;
	private IWorkbenchAction selectAllAction;
	private IWorkbenchAction deleteAction;
	private IWorkbenchAction pasteAction;
	private IWorkbenchAction copyAction;
	private IWorkbenchAction cutAction;
	private IWorkbenchAction redoAction;
	private IWorkbenchAction undoAction;
	private IWorkbenchAction propertiesAction;
	private IWorkbenchAction exportAction;
	private IWorkbenchAction importAction;
	private IWorkbenchAction printAction;
	private IWorkbenchAction refreshAction;
	private IWorkbenchAction renameAction;
	private IWorkbenchAction moveAction;
	private IWorkbenchAction revertAction;
	private IWorkbenchAction saveAllAction;
	private IWorkbenchAction quitAction;
	private IWorkbenchAction saveAsAction;
	private IWorkbenchAction saveAction;
//	private IWorkbenchAction closeAllSavedAction;
	private IWorkbenchAction closeAllAction;
	private IWorkbenchAction closeAction;
	private IWorkbenchAction newWizardDropDownAction;
	private IWorkbenchAction newAction;
	public IpssAppActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {
		{
			newAction = ActionFactory.NEW.create(window);
			register(newAction);
		}
		{
			newWizardDropDownAction = ActionFactory.NEW_WIZARD_DROP_DOWN.create(window);
			register(newWizardDropDownAction);
		}
		{
			closeAction = ActionFactory.CLOSE.create(window);
			register(closeAction);
		}
		{
			closeAllAction = ActionFactory.CLOSE_ALL.create(window);
			register(closeAllAction);
		}
//		{
//			closeAllSavedAction = ActionFactory.CLOSE_ALL_SAVED.create(window);
//			register(closeAllSavedAction);
//		}
		{
			saveAction = ActionFactory.SAVE.create(window);
			register(saveAction);
		}
		{
			saveAsAction = ActionFactory.SAVE_AS.create(window);
			register(saveAsAction);
		}
		{
			quitAction = ActionFactory.QUIT.create(window);
			register(quitAction);
		}
		{
			saveAllAction = ActionFactory.SAVE_ALL.create(window);
			register(saveAllAction);
		}
		{
			revertAction = ActionFactory.REVERT.create(window);
			register(revertAction);
		}
		{
			moveAction = ActionFactory.MOVE.create(window);
			register(moveAction);
		}
		{
			renameAction = ActionFactory.RENAME.create(window);
			register(renameAction);
		}
		{
			refreshAction = ActionFactory.REFRESH.create(window);
			register(refreshAction);
		}
		{
			printAction = ActionFactory.PRINT.create(window);
			register(printAction);
		}
		{
			importAction = ActionFactory.IMPORT.create(window);
			register(importAction);
		}
		{
			exportAction = ActionFactory.EXPORT.create(window);
			register(exportAction);
		}
		{
			propertiesAction = ActionFactory.PROPERTIES.create(window);
			register(propertiesAction);
		}
		{
			undoAction = ActionFactory.UNDO.create(window);
			register(undoAction);
		}
		{
			redoAction = ActionFactory.REDO.create(window);
			register(redoAction);
		}
		{
			cutAction = ActionFactory.CUT.create(window);
			register(cutAction);
		}
		{
			copyAction = ActionFactory.COPY.create(window);
			register(copyAction);
		}
		{
			pasteAction = ActionFactory.PASTE.create(window);
			register(pasteAction);
		}
		{
			deleteAction = ActionFactory.DELETE.create(window);
			register(deleteAction);
		}
		{
			selectAllAction = ActionFactory.SELECT_ALL.create(window);
			register(selectAllAction);
		}
		{
			findAction = ActionFactory.FIND.create(window);
			register(findAction);
		}
		{
			goIntoAction = ActionFactory.GO_INTO.create(window);
			register(goIntoAction);
		}
		{
			nextAction = ActionFactory.NEXT.create(window);
			register(nextAction);
		}
		{
			backAction = ActionFactory.BACK.create(window);
			register(backAction);
		}
		{
			upAction = ActionFactory.UP.create(window);
			register(upAction);
		}
		{
			previousAction = ActionFactory.PREVIOUS.create(window);
			register(previousAction);
		}
		{
			forwardAction = ActionFactory.FORWARD.create(window);
			register(forwardAction);
		}
		{
			backwardHistoryAction = ActionFactory.BACKWARD_HISTORY.create(window);
			register(backwardHistoryAction);
		}
		{
			forwardHistoryAction = ActionFactory.FORWARD_HISTORY.create(window);
			register(forwardHistoryAction);
		}
		{
			preferencesAction = ActionFactory.PREFERENCES.create(window);
			register(preferencesAction);
		}
		{
			openNewWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
			register(openNewWindowAction);
		}
		{
			newEditorAction = ActionFactory.NEW_EDITOR.create(window);
			register(newEditorAction);
		}
		{
			openPerspectiveDialogAction = ActionFactory.OPEN_PERSPECTIVE_DIALOG.create(window);
			register(openPerspectiveDialogAction);
		}
		{
			showViewMenuAction = ActionFactory.SHOW_VIEW_MENU.create(window);
			register(showViewMenuAction);
		}
		{
			editActionSetsAction = ActionFactory.EDIT_ACTION_SETS.create(window);
			register(editActionSetsAction);
		}
		{
			savePerspectiveAction = ActionFactory.SAVE_PERSPECTIVE.create(window);
			register(savePerspectiveAction);
		}
		{
			resetPerspectiveAction = ActionFactory.RESET_PERSPECTIVE.create(window);
			register(resetPerspectiveAction);
		}
		{
			closePerspectiveAction = ActionFactory.CLOSE_PERSPECTIVE.create(window);
			register(closePerspectiveAction);
		}
		{
			closeAllPerspectivesAction = ActionFactory.CLOSE_ALL_PERSPECTIVES.create(window);
			register(closeAllPerspectivesAction);
		}
		{
			showPartPaneMenuAction = ActionFactory.SHOW_PART_PANE_MENU.create(window);
			register(showPartPaneMenuAction);
		}
		{
			maximizeAction = ActionFactory.MAXIMIZE.create(window);
			register(maximizeAction);
		}
		{
			minimizeAction = ActionFactory.MINIMIZE.create(window);
			register(minimizeAction);
		}
		{
			activateEditorAction = ActionFactory.ACTIVATE_EDITOR.create(window);
			register(activateEditorAction);
		}
		{
			nextEditorAction = ActionFactory.NEXT_EDITOR.create(window);
			register(nextEditorAction);
		}
		{
			previousEditorAction = ActionFactory.PREVIOUS_EDITOR.create(window);
			register(previousEditorAction);
		}
		{
			showOpenEditorsAction = ActionFactory.SHOW_OPEN_EDITORS.create(window);
			register(showOpenEditorsAction);
		}
		{
			showWorkbookEditorsAction = ActionFactory.SHOW_WORKBOOK_EDITORS.create(window);
			register(showWorkbookEditorsAction);
		}
		{
			nextPartAction = ActionFactory.NEXT_PART.create(window);
			register(nextPartAction);
		}
		{
			previousPartAction = ActionFactory.PREVIOUS_PART.create(window);
			register(previousPartAction);
		}
		{
			nextPerspectiveAction = ActionFactory.NEXT_PERSPECTIVE.create(window);
			register(nextPerspectiveAction);
		}
		{
			previousPerspectiveAction = ActionFactory.PREVIOUS_PERSPECTIVE.create(window);
			register(previousPerspectiveAction);
		}
		{
			lockToolBarAction = ActionFactory.LOCK_TOOL_BAR.create(window);
			register(lockToolBarAction);
		}
//		{
//			introAction = ActionFactory.INTRO.create(window);
//			register(introAction);
//		}
		{
			helpContentsAction = ActionFactory.HELP_CONTENTS.create(window);
			register(helpContentsAction);
		}
		{
			helpSearchAction = ActionFactory.HELP_SEARCH.create(window);
			register(helpSearchAction);
		}
		{
			dynamicHelpAction = ActionFactory.DYNAMIC_HELP.create(window);
			register(dynamicHelpAction);
		}
		{
			aboutAction = ActionFactory.ABOUT.create(window);
			register(aboutAction);
		}

//		// file menu
//		exitAction = ActionFactory.QUIT.create(window);
//		register(exitAction);
//
//		newAction = ActionFactory.NEW.create(window);
//		register(newAction);
//
//		// help menu
//		aboutAction = ActionFactory.ABOUT.create(window);
//		register(aboutAction);

	}

	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		final ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		coolBar.add(toolBarManager);

		toolBarManager.add(newWizardDropDownAction);

		toolBarManager.add(new Separator());

		toolBarManager.add(saveAction);

		toolBarManager.add(saveAllAction);
/*
		toolBarManager.add(new Separator());

		toolBarManager.add(copyAction);

		toolBarManager.add(cutAction);

		toolBarManager.add(pasteAction);

		toolBarManager.add(new Separator());

		toolBarManager.add(printAction);
		// TODO Auto-generated method stub
		 */
		super.fillCoolBar(coolBar);
	}

	protected void fillMenuBar(IMenuManager menuBar) {
//
//		MenuManager file_newMenu = new MenuManager(MessageUtil.getString("Menu.New.text"), null);
//		fileMenu.add(file_newMenu);
//		file_newMenu.add(newAction);
//
//		fileMenu.add(new Separator());
//		fileMenu.add(exitAction);
//
//		MenuManager helpMenu = new MenuManager(MessageUtil.getString("Menu.Help.text"), null);
//		helpMenu.add(aboutAction);
//		menuBar.add(fileMenu);
//		menuBar.add(helpMenu);
		MenuManager fileMenu = new MenuManager("&File", null);
		menuBar.add(fileMenu);

		fileMenu.add(newAction);

		fileMenu.add(newWizardDropDownAction);

		fileMenu.add(new Separator());

		fileMenu.add(closeAction);

		fileMenu.add(closeAllAction);

//		fileMenu.add(closeAllSavedAction);

		fileMenu.add(new Separator());

		fileMenu.add(saveAction);
//		MenuManager fileMenu = new MenuManager(MessageUtil.getString("Menu.File.text"), null);

		fileMenu.add(saveAsAction);

		fileMenu.add(saveAllAction);

		fileMenu.add(revertAction);

		fileMenu.add(new Separator());

		fileMenu.add(moveAction);

		fileMenu.add(renameAction);

		fileMenu.add(refreshAction);

		fileMenu.add(new Separator());

		fileMenu.add(printAction);

		fileMenu.add(new Separator());

		fileMenu.add(importAction);

		fileMenu.add(exportAction);

		fileMenu.add(new Separator());

		fileMenu.add(propertiesAction);

		fileMenu.add(new Separator());

		fileMenu.add(quitAction);
		
		MenuManager editMenu = new MenuManager("&Edit", null);
		menuBar.add(editMenu);

		editMenu.add(undoAction);

		editMenu.add(redoAction);

		editMenu.add(new Separator());

		editMenu.add(cutAction);

		editMenu.add(copyAction);

		editMenu.add(pasteAction);

		editMenu.add(new Separator());

		editMenu.add(deleteAction);

		editMenu.add(selectAllAction);

		editMenu.add(new Separator());

		editMenu.add(findAction);
		
/*		
		MenuManager navMenu = new MenuManager("&Navigate", null);
		menuBar.add(navMenu);

		navMenu.add(goIntoAction);

		navMenu.add(backAction);

		navMenu.add(upAction);

		navMenu.add(nextAction);

		navMenu.add(previousAction);

		navMenu.add(forwardAction);

		navMenu.add(backwardHistoryAction);

		navMenu.add(forwardHistoryAction);
*/
		MenuManager winMenu = new MenuManager("&Window", null);
		menuBar.add(winMenu);

		winMenu.add(openNewWindowAction);

		winMenu.add(newEditorAction);

		winMenu.add(new Separator());

		winMenu.add(openPerspectiveDialogAction);

		winMenu.add(showViewMenuAction);

		winMenu.add(new Separator());

		winMenu.add(editActionSetsAction);

		winMenu.add(savePerspectiveAction);

		winMenu.add(resetPerspectiveAction);

		winMenu.add(closePerspectiveAction);

		winMenu.add(closeAllPerspectivesAction);
/*
		MenuManager winnavMenu = new MenuManager("Navigate", null);
		winMenu.add(winnavMenu);

		winnavMenu.add(showPartPaneMenuAction);

		winnavMenu.add(showViewMenuAction);

		winnavMenu.add(new Separator());

		winnavMenu.add(maximizeAction);

		winnavMenu.add(minimizeAction);

		winnavMenu.add(new Separator());

		winnavMenu.add(activateEditorAction);

		winnavMenu.add(nextEditorAction);

		winnavMenu.add(previousEditorAction);

		winnavMenu.add(showOpenEditorsAction);

		winnavMenu.add(showWorkbookEditorsAction);

		winnavMenu.add(new Separator());

		winnavMenu.add(nextPartAction);

		winnavMenu.add(previousPartAction);

		winnavMenu.add(new Separator());

		winnavMenu.add(nextPerspectiveAction);

		winnavMenu.add(previousPerspectiveAction);

		winMenu.add(new Separator());

		winMenu.add(lockToolBarAction);

		winMenu.add(new Separator());

		winMenu.add(preferencesAction);
*/
		MenuManager helpMenu = new MenuManager("&Help", null);
		menuBar.add(helpMenu);

//		helpMenu.add(introAction);
//
//		helpMenu.add(new Separator());

		helpMenu.add(helpContentsAction);

		helpMenu.add(helpSearchAction);

		helpMenu.add(dynamicHelpAction);

		helpMenu.add(new Separator());

		helpMenu.add(aboutAction);

	}

}
