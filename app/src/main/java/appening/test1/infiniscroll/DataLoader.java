package appening.test1.infiniscroll;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ze on 02/07/2015.
 */

/* Class that loads more events (currently EventHeaderInfo instances) from a data source
 * Source can be a POJO, database, RESTful service, etc.
 * For now it's only a mockup which loads data from a pre-set list.
 */
public class DataLoader<DataType>
{

    private final int pageSize;
    List<List<DataType>> paginatedData;

    //e.g.
    //URL dataURL
    //JDBC Driver dataDB
    //RESTful crap, etc.

    public DataLoader(int pageSize)
    {
        this.pageSize = pageSize;
    }

    //for test purposes only
    void setData(List<List<DataType>> data)
    {
        this.paginatedData = data;
    }

    //for test purposes only
    void addPage(List<DataType> dataPage)
    {
        paginatedData.add(dataPage);
    }

    List<DataType> loadPage(int page)
    {
        if (page > paginatedData.size() - 1)
        {
            // empty page
            return new ArrayList<DataType>();
        }
        return paginatedData.get(page);
    }

    void loadEvents(int offset, int count)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
