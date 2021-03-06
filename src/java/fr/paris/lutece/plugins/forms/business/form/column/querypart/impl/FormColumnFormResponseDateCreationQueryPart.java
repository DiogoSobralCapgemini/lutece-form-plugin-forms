/*
 * Copyright (c) 2002-2018, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.forms.business.form.column.querypart.impl;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import fr.paris.lutece.plugins.forms.util.FormMultiviewFormResponseDateCreationNameConstants;
import fr.paris.lutece.util.sql.DAOUtil;

/**
 * Implementation of the IFormColumnQueryPart interface for a form response date creation column
 */
public class FormColumnFormResponseDateCreationQueryPart extends AbstractFormColumnQueryPart
{
    // Constants
    private static final String FORM_RESPONSE_DATE_CREATION_SELECT_QUERY_PART = "response.creation_date AS response_creation_date";
    private static final String FORM_RESPONSE_DATE_CREATION_FROM_QUERY_PART = StringUtils.EMPTY;
    private static final String FORM_RESPONSE_DATE_CREATION_JOIN_QUERY_PART = StringUtils.EMPTY;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFormColumnSelectQuery( )
    {
        return FORM_RESPONSE_DATE_CREATION_SELECT_QUERY_PART;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFormColumnFromQuery( )
    {
        return FORM_RESPONSE_DATE_CREATION_FROM_QUERY_PART;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getFormColumnJoinQueries( )
    {
        return Arrays.asList( FORM_RESPONSE_DATE_CREATION_JOIN_QUERY_PART );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Map<String, Object> getMapFormColumnValues( DAOUtil daoUtil )
    {
        Map<String, Object> mapFormColumnValues = new LinkedHashMap<>( );
        Timestamp timestampFormResponseDateCreation = daoUtil
                .getTimestamp( FormMultiviewFormResponseDateCreationNameConstants.COLUMN_FORM_RESPONSE_DATE_CREATION );
        Date dateFormResponseDateCreation = new Date( timestampFormResponseDateCreation.getTime( ) );
        mapFormColumnValues.put( FormMultiviewFormResponseDateCreationNameConstants.COLUMN_FORM_RESPONSE_DATE_CREATION, dateFormResponseDateCreation );

        return mapFormColumnValues;
    }
}
