package com.vendertool.fts.dal.daocodegen;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTask is a Querydsl query type for QTask
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QTask extends com.mysema.query.sql.RelationalPathBase<QTask> {

    private static final long serialVersionUID = -2126132232;

    public static final QTask task = new QTask("task");

    public final NumberPath<Long> accountId = createNumber("account_id", Long.class);

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("created_date", java.sql.Timestamp.class);

    public final StringPath isoCountryCode = createString("iso_country_code");

    public final NumberPath<Long> jobId = createNumber("job_id", Long.class);

    public final DateTimePath<java.sql.Timestamp> lastModifiedDate = createDateTime("last_modified_date", java.sql.Timestamp.class);

    public final NumberPath<Long> recordId = createNumber("record_id", Long.class);

    public final SimplePath<byte[]> request = createSimple("request", byte[].class);

    public final NumberPath<Long> requestFileId = createNumber("request_file_id", Long.class);

    public final StringPath requestGroupId = createString("request_group_id");

    public final SimplePath<byte[]> response = createSimple("response", byte[].class);

    public final NumberPath<Byte> status = createNumber("status", Byte.class);

    public final NumberPath<Long> taskId = createNumber("task_id", Long.class);

    public final com.mysema.query.sql.PrimaryKey<QTask> primary = createPrimaryKey(taskId);

    public QTask(String variable) {
        super(QTask.class, forVariable(variable), "null", "task");
    }

    @SuppressWarnings("all")
    public QTask(Path<? extends QTask> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "task");
    }

    public QTask(PathMetadata<?> metadata) {
        super(QTask.class, metadata, "null", "task");
    }

}

