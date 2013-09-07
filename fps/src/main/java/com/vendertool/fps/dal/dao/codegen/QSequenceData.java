package com.vendertool.fps.dal.dao.codegen;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSequenceData is a Querydsl query type for QSequenceData
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QSequenceData extends com.mysema.query.sql.RelationalPathBase<QSequenceData> {

    private static final long serialVersionUID = -619046054;

    public static final QSequenceData sequenceData = new QSequenceData("sequence_data");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("created_date", java.sql.Timestamp.class);

    public final NumberPath<Long> curValue = createNumber("cur_value", Long.class);

    public final NumberPath<Integer> increment = createNumber("increment", Integer.class);

    public final NumberPath<Byte> isRecycle = createNumber("is_recycle", Byte.class);

    public final DateTimePath<java.sql.Timestamp> lastModifiedDate = createDateTime("last_modified_date", java.sql.Timestamp.class);

    public final NumberPath<Long> maxValue = createNumber("max_value", Long.class);

    public final NumberPath<Integer> minValue = createNumber("min_value", Integer.class);

    public final StringPath sequenceName = createString("sequence_name");

    public final com.mysema.query.sql.PrimaryKey<QSequenceData> primary = createPrimaryKey(sequenceName);

    public QSequenceData(String variable) {
        super(QSequenceData.class, forVariable(variable), "null", "sequence_data");
    }

    @SuppressWarnings("all")
    public QSequenceData(Path<? extends QSequenceData> path) {
        super((Class)path.getType(), path.getMetadata(), "null", "sequence_data");
    }

    public QSequenceData(PathMetadata<?> metadata) {
        super(QSequenceData.class, metadata, "null", "sequence_data");
    }

}

