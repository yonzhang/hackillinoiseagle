package org.apache.eagle.correlation.client;

import java.util.List;
import java.util.Map;

/**
 * Created by yonzhang on 2/20/16.
 */
public interface IMetadataClient {
	List<String> findAllTopics();

	Map<String, List<String>> findAllGroups();
}
