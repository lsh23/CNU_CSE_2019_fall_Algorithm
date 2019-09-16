
def mergy_sort(list):
    if(len(list) == 1):
        return list
    len_of_list = len(list)
    r_list = mergy_sort(list[:int((len_of_list/2))])
    l_list = mergy_sort(list[int((len_of_list/2)):])

    len_r_list_end_index = len(r_list) - 1
    len_l_list_end_index = len(l_list) - 1

    mergyed_list = []

    count = 0
    i = 0
    j = 0

    while(count != len_of_list):
        if(i > len_r_list_end_index):
            while(j < len_l_list_end_index):
                mergyed_list.append(l_list[j])
            break
        if(j > len_l_list_end_index):
            while(i < len_l_list_end_index):
                mergyed_list.append(r_list[i])
            break
        if(r_list[i] > l_list[j]):
            mergyed_list.append(l_list[j])
            j = j + 1
            count = count + 1
        else:
            mergyed_list.append(r_list[i])
            i = i + 1
            count = count + 1

    return mergyed_list

print(mergy_sort([1,2,8,235,23424,3,6,234,3]))
