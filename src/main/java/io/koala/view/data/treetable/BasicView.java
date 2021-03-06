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

import io.koala.domain.Document;
import io.koala.service.DocumentService;
import org.primefaces.model.TreeNode;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("ttBasicView")
@ViewScoped
public class BasicView implements Serializable {

	private TreeNode root;

	private Document selectedDocument;

//	@ManagedProperty("#{documentService}")
	private DocumentService service;

	@Inject
	public BasicView(DocumentService service) {
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

	public Document getSelectedDocument() {
		return selectedDocument;
	}

	public void setSelectedDocument(Document selectedDocument) {
		this.selectedDocument = selectedDocument;
	}
}
