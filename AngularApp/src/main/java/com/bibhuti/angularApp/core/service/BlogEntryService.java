package com.bibhuti.angularApp.core.service;

import com.bibhuti.angularApp.core.model.entities.BlogEntry;
import com.bibhuti.angularApp.core.service.exceptions.BlogNotFoundException;

public interface BlogEntryService {

public BlogEntry findBlogEntryById(String id) throws BlogNotFoundException;

public BlogEntry updateBlogEntry(String id,BlogEntry blogData);

public BlogEntry deleteBlogEntry(String id);

}

