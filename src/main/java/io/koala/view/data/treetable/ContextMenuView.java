/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.koala.view.data.treetable;

import io.koala.service.DocumentService;
import org.primefaces.model.TreeNode;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("ttContextMenuView")
@ViewScoped
public class ContextMenuView implements Serializable {

	private TreeNode root;

	private TreeNode selectedNode;

//	@ManagedProperty("#{documentService}")
	private DocumentService service;

	@Inject
	public ContextMenuView(DocumentService service) {
		this.service = service;
	}

	@PostConstruct
	public void init() {
		root = service.createDocuments();
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setService(DocumentService service) {
		this.service = service;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public void deleteNode() {
		selectedNode.getChildren().clear();
		selectedNode.getParent().getChildren().remove(selectedNode);
		selectedNode.setParent(null);

		selectedNode = null;
	}
}
